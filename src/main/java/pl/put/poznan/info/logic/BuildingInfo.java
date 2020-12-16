package pl.put.poznan.info.logic;

import com.google.gson.Gson;

public class BuildingInfo {

    private Building building;

    public BuildingInfo(String info) {
        readJSON(info);
    }

    public void readJSON(String info) {
        this.building = new Gson().fromJson(info, Building.class);
    }

    public String calculateBuildingArea(){
        int area = 0;
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                area += r.getArea();
            }
        }
        return String.valueOf(area);
    }

    public String calculateLevelArea(String id) {
        int area = 0;
        for (Level l : building.getLevels()) {
            if (l.getId().equals(id)){
                for (Room r: l.getRooms()) {
                    area += r.getArea();
                }
                return String.valueOf(area);
            }
        }
        return "No level with the given id.";
    }

    public String calculateRoomArea(String id) {
        for (Level l : building.getLevels()) {
            for (Room r: l.getRooms()) {
                if (r.getId().equals(id)) {
                    return String.valueOf(r.getArea());
                }
            }
        }
        return "No room with the given id.";
    }
}
