package pl.put.poznan.info.logic;

import com.google.gson.Gson;

/**
 * This is the BuildingInfoArea class, which returns info about area in the builing.
 */
public class BuildingInfoArea implements BuildingInfo {

    private Building building;

    public BuildingInfoArea(String info) {
        readJSON(info);
    }

    public void readJSON(String info) {
        this.building = new Gson().fromJson(info, Building.class);
    }

    /**
     * Counts area of the building.
     * @return area
     */
    public String calculateBuilding(){
        return String.valueOf(building.countArea());
    }

    /**
     * Counts area of the level.
     * @param id level id
     * @return area or message "No level with the given id."
     */
    public String calculateLevel(String id) {
        for (Level l : building.getLocations()) {
            if (l.getId().equals(id)){
                return String.valueOf(l.countArea());
            }
        }
        return "No level with the given id.";
    }

    /**
     * Counts area of the room.
     * @param id room id
     * @return area or message "No room with the given id."
     */
    public String calculateRoom(String id) {
        for (Level l : building.getLocations()) {
            for (Room r: l.getLocations()) {
                if (r.getId().equals(id)) {
                    return String.valueOf(r.getArea());
                }
            }
        }
        return "No room with the given id.";
    }
}
