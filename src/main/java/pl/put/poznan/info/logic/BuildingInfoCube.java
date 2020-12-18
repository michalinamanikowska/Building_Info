package pl.put.poznan.info.logic;

import com.google.gson.Gson;

public class BuildingInfoCube implements BuildingInfo {

    private Building building;

    public BuildingInfoCube(String info) {
        readJSON(info);
    }

    public void readJSON(String info) {
        this.building = new Gson().fromJson(info, Building.class);
    }

    public String calculateBuilding(){
        int cube = 0;
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                cube += r.getCube();
            }
        }
        return String.valueOf(cube);
    }

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
