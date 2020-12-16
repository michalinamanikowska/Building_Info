package pl.put.poznan.info.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
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
