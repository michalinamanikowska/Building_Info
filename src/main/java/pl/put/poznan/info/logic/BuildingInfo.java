package pl.put.poznan.info.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This is the BuildingInfo class, which returns info about area, cube, heating and light in the building.
 */
public class BuildingInfo {
    private MidLocation building;

    /**
     * This is the BuildingInfo constructor, which reads the json String with building data and creates the instance of the MidLocation class.
     *
     * @param buildingData data with json building structure
     */
    public BuildingInfo(String buildingData) throws JSONException {
        JSONObject jsonBuilding = new JSONObject(buildingData);
        MidLocation building = new MidLocation(jsonBuilding.getString("id"), jsonBuilding.getString("name"));

        JSONArray jsonLevels = jsonBuilding.getJSONArray("levels");
        int numberOfLevels = jsonLevels.length();

        for (int i = 0; i < numberOfLevels; ++i) {
            JSONObject jsonLevel = jsonLevels.getJSONObject(i);
            MidLocation level = new MidLocation(jsonLevel.getString("id"), jsonLevel.getString("name"));

            JSONArray jsonRooms = jsonLevel.getJSONArray("rooms");
            int numberOfRooms = jsonRooms.length();
            System.out.println(numberOfRooms);

            for (int j = 0; j < numberOfRooms; ++j) {
                JSONObject jsonRoom = jsonRooms.getJSONObject(j);
                Room room = new Room(jsonRoom.getString("id"), jsonRoom.getString("name"), jsonRoom.getInt("area"), jsonRoom.getInt("cube"), (float) jsonRoom.getDouble("heating"), jsonRoom.getInt("light"));
                System.out.println(room.getId());
                level.addLocation(room);
            }
            building.addLocation(level);
        }

        this.building = building;
    }

    /**
     * Counts total area of the building.
     *
     * @return area of the building
     */
    public String calculateTotalArea() {
        return String.valueOf(building.countTotalArea());
    }

    /**
     * Counts area of the location specified by id.
     *
     * @param id the id of the required location
     * @return area of the location specified by id
     */
    public String calculateAreaById(String id) {
        return String.valueOf(building.countAreaById(id));
    }

    /**
     * Counts total cube of the building.
     *
     * @return cube of the building
     */
    public String calculateTotalCube() {
        return String.valueOf(building.countTotalCube());
    }

    /**
     * Counts cube of the location specified by id.
     *
     * @param id the id of the required location
     * @return cube of the location specified by id
     */
    public String calculateCubeById(String id) {
        return String.valueOf(building.countCubeById(id));
    }

    /**
     * Counts total heating of the building.
     *
     * @return heating of the building
     */
    public String calculateTotalHeating() {
        return String.valueOf(building.countTotalHeating());
    }

    /**
     * Counts heating of the location specified by id.
     *
     * @param id the id of the required location
     * @return heating of the location specified by id
     */
    public String calculateHeatingById(String id) {
        return String.valueOf(building.countHeatingById(id));
    }

    /**
     * Counts total light of the building.
     *
     * @return light of the building
     */
    public String calculateTotalLight() {
        return String.valueOf(building.countTotalLight());
    }

    /**
     * Counts light of the location specified by id.
     *
     * @param id the id of the required location
     * @return light of the location specified by id
     */
    public String calculateLightById(String id) {
        return String.valueOf(building.countLightById(id));
    }
}