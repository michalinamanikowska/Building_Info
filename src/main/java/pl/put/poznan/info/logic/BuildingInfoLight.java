package pl.put.poznan.info.logic;

import com.google.gson.Gson;

public class BuildingInfoLight {

    private Building building;

    public BuildingInfoLight(String info) {
        readJSON(info);
    }

    public void readJSON(String info) {
        this.building = new Gson().fromJson(info, Building.class);
    }

    public String calculateBuildingLight(){
        int cube = 0;
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                cube += r.getLight();
            }
        }
        return String.valueOf(cube);
    }

    public String calculateLevelLight(String id) {
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

    public String calculateRoomLight(String id) {
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
