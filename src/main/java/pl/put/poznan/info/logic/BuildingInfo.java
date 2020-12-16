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

    public String inform(String text){
        // of course, normally it would do something based on the info
        return text.toUpperCase();
    }
}
