package pl.put.poznan.info.logic;

import com.google.gson.Gson;
/**
 * This is the BuildingInfoArLight class, which returns info about power of light in the builing.
 */
public class BuildingInfoLight implements BuildingInfo {

    private Building building;

    public BuildingInfoLight(String info) {
        readJSON(info);
    }

    /**
     * Read the file with info about the builing.
     */
    public void readJSON(String info) {
        this.building = new Gson().fromJson(info, Building.class);
    }

    /**
     * Counts power of the light in the building.
     * @return power of the light
     */
    public String calculateBuilding(){
        return String.valueOf(building.countLight());
    }

    /**
     * Counts power of the light on the level.
     * @param id level id
     * @return power of the light or message "No level with the given id."
     */
    public String calculateLevel(String id) {
        for (Level l : building.getLocations()) {
            if (l.getId().equals(id)){
                return String.valueOf(l.countLight());
            }
        }
        return "No level with the given id.";
    }

    /**
     * Counts power of the light in the room
     * @param id level id
     * @return power of the light or message "No room with the given id."
     */
    public String calculateRoom(String id) {
        for (Level l : building.getLocations()) {
            for (Room r: l.getLocations()) {
                if (r.getId().equals(id)) {
                    return String.valueOf(r.getLight());
                }
            }
        }
        return "No room with the given id.";
    }
}
