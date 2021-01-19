package pl.put.poznan.info.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This is the BuildingInfo class, which returns info about area, cube, heating and light in the building.
 */
public class BuildingInfo {
    /**
     * the building attribute
     */
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

            for (int j = 0; j < numberOfRooms; ++j) {
                JSONObject jsonRoom = jsonRooms.getJSONObject(j);
                Room room = new Room(jsonRoom.getString("id"), jsonRoom.getString("name"), jsonRoom.getInt("area"), jsonRoom.getInt("cube"), (float) jsonRoom.getDouble("heating"), jsonRoom.getInt("light"));
                level.addLocation(room);
            }
            building.addLocation(level);
        }

        this.building = building;
    }

    /**
     * This is the BuildingInfo constructor, which assigns the MidLocation parameter value to the building attribute.
     *
     * @param building MidLocation building object
     */
    public BuildingInfo(MidLocation building) {
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
     * Finds rooms with area smaller or equal to specified limit level.
     *
     * @param level the specified area limit level
     * @return ids of locations within limited area level
     */
    public String findRoomsWithLimitedAreaLevel(String level) {
        return building.findRoomsWithLimitedAreaLevel(level);
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
     * Finds rooms with cube smaller or equal to specified limit level.
     *
     * @param level the specified cube limit level
     * @return ids of locations within limited cube level
     */
    public String findRoomsWithLimitedCubeLevel(String level) {
        return building.findRoomsWithLimitedCubeLevel(level);
    }

    /**
     * Counts total heating of the building.
     *
     * @return heating of the building
     */
    public String calculateTotalHeating() {
        return String.valueOf(building.countTotalHeating()/building.countTotalCube());
    }

    /**
     * Counts heating of the location specified by id.
     *
     * @param id the id of the required location
     * @return heating of the location specified by id
     */
    public String calculateHeatingById(String id) {
        return String.valueOf(building.countHeatingById(id)/building.countCubeById(id));
    }

    /**
     * Finds rooms with heating exceeding specified level.
     *
     * @param level the specified heating level
     * @return ids of locations exceeding specified heating level
     */
    public String findRoomsWithExceededHeatingLevel(String level) {
        return building.findRoomsWithExceededHeatingLevel(level);
    }

    /**
     * Finds rooms with heating smaller or equal to specified limit level.
     *
     * @param level the specified heating limit level
     * @return ids of locations within limited heating level
     */
    public String findRoomsWithLimitedHeatingLevel(String level) {
        return building.findRoomsWithLimitedHeatingLevel(level);
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

    /**
     * Finds rooms with light smaller or equal to specified limit level.
     *
     * @param level the specified light limit level
     * @return ids of locations within limited light level
     */
    public String findRoomsWithLimitedLightLevel(String level) {
        return building.findRoomsWithLimitedLightLevel(level);
    }
}