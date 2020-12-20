package pl.put.poznan.info.logic;

import com.google.gson.Gson;

/**
 * This is the BuildingInfoCube class, which returns info about cube in the builing.
 */
public class BuildingInfoCube implements BuildingInfo {

    private Building building;

    public BuildingInfoCube(String info) {
        readJSON(info);
    }

    /**
     * Read the file with info about the builing.
     */
    public void readJSON(String info) {
        this.building = new Gson().fromJson(info, Building.class);
    }

    /**
     * Counts cube of the building.
     * @return cube
     */
    public String calculateBuilding(){
        int cube = 0;
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                cube += r.getCube();
            }
        }
        return String.valueOf(cube);
    }

    /**
     * Counts cube of the level.
     * @param id level id
     * @return cube or message "No level with the given id."
     */
    public String calculateLevel(String id) {
        int cube = 0;
        for (Level l : building.getLevels()) {
            if (l.getId().equals(id)){
                for (Room r: l.getRooms()) {
                    cube += r.getCube();
                }
                return String.valueOf(cube);
            }
        }
        return "No level with the given id.";
    }

    /**
     * Counts cube of the level.
     * @param id level id
     * @return cube or message "No level with the given id."
     */
    public String calculateRoom(String id) {
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                if (r.getId().equals(id)) {
                    return String.valueOf(r.getCube());
                }
            }
        }
        return "No room with the given id.";
    }
}
