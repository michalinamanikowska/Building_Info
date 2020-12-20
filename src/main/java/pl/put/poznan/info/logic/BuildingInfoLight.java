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
        int cube = 0;
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                cube += r.getLight();
            }
        }
        return String.valueOf(cube);
    }

    /**
     * Counts power of the light on the level.
     * @param id level id
     * @return power of the light or message "No level with the given id."
     */
    public String calculateLevel(String id) {
        int cube = 0;
        for (Level l : building.getLevels()) {
            if (l.getId().equals(id)){
                for (Room r: l.getRooms()) {
                    cube += r.getLight();
                }
                return String.valueOf(cube);
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
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                if (r.getId().equals(id)) {
                    return String.valueOf(r.getLight());
                }
            }
        }
        return "No room with the given id.";
    }
}
