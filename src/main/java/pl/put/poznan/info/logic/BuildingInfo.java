package pl.put.poznan.info.logic;

import com.google.gson.Gson;

/**
 * This is the BuildingInfoArea class, which returns info about area in the builing.
 */
public class BuildingInfo {

    private MidLocation building;

    public BuildingInfo() {
        Room room1 = new Room("l1-r1","lecture hall 1", 244, 1220, (float) 31.72, 2500);
        Room room2 = new Room("l1-r2","toilet", 16, 48, (float) 2.08, 280);

        MidLocation level1 = new MidLocation("l1", "level 1");
        level1.addLocation(room1);
        level1.addLocation(room2);

        Room room3 = new Room("l2-r1","lecture hall 2", 120, 600, (float) 15.6, 1500);

        MidLocation level2 = new MidLocation("l2", "level 2");
        level2.addLocation(room3);

        MidLocation building1 = new MidLocation("b1", "university");
        building1.addLocation(level1);
        building1.addLocation(level2);

        this.building = building1;

        building1.accept(new LocationVisit());
    }

    /**
     * Counts total area of the building.
     * @return area
     */
    public String calculateTotalArea(){
        return String.valueOf(building.countTotalArea());
    }
    /**
     * Counts area of the location specified by id.
     * @return area
     */
    public String calculateAreaById(String id){
        return String.valueOf(building.countAreaById(id));
    }

    /**
     * Counts total cube of the building.
     * @return cube
     */
    public String calculateTotalCube(){
        return String.valueOf(building.countTotalCube());
    }
    /**
     * Counts cube of the location specified by id.
     * @return cube
     */
    public String calculateCubeById(String id){
        return String.valueOf(building.countCubeById(id));
    }

    /**
     * Counts total heating of the building.
     * @return heating
     */
    public String calculateTotalHeating(){
        return String.valueOf(building.countTotalHeating());
    }
    /**
     * Counts heating of the location specified by id.
     * @return heating
     */
    public String calculateHeatingById(String id){
        return String.valueOf(building.countHeatingById(id));
    }

    /**
     * Counts total light of the building.
     * @return light
     */
    public String calculateTotalLight(){
        return String.valueOf(building.countTotalLight());
    }
    /**
     * Counts light of the location specified by id.
     * @return light
     */
    public String calculateLightById(String id){
        return String.valueOf(building.countLightById(id));
    }
}
