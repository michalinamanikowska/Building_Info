package pl.put.poznan.info.logic;

import com.google.gson.Gson;

public class BuildingInfo {

    private final String[] info;

    public BuildingInfo(String[] info){
        this.info = info;
    }

    public String inform(String text){
        // of course, normally it would do something based on the info
        return text.toUpperCase();
    }
}
