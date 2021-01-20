package pl.put.poznan.info.logic;

import org.json.*;

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
    public String calculateTotalArea() throws JSONException {
        JSONObject area = new JSONObject();
        area.put("area", String.valueOf(building.countTotalArea()));
        return area.toString();
    }

    /**
     * Counts area of the location specified by id.
     *
     * @param id the id of the required location
     * @return area of the location specified by id
     */
    public String calculateAreaById(String id) throws JSONException {
        JSONObject area = new JSONObject();
        area.put("area", String.valueOf(building.countAreaById(id)));
        return area.toString();
    }

    /**
     * Finds rooms with area smaller or equal to specified limit level.
     *
     * @param level the specified area limit level
     * @return ids of locations within limited area level
     */
    public String findRoomsWithLimitedAreaLevel(String level) throws JSONException {
        JSONObject rooms = new JSONObject();
        rooms.put("rooms", building.findRoomsWithLimitedAreaLevel(level));
        return rooms.toString();
    }

    /**
     * Counts total cube of the building.
     *
     * @return cube of the building
     */
    public String calculateTotalCube() throws JSONException {
        JSONObject cube = new JSONObject();
        cube.put("cube", String.valueOf(building.countTotalCube()));
        return cube.toString();
    }

    /**
     * Counts cube of the location specified by id.
     *
     * @param id the id of the required location
     * @return cube of the location specified by id
     */
    public String calculateCubeById(String id) throws JSONException {
        JSONObject cube = new JSONObject();
        cube.put("cube", String.valueOf(building.countCubeById(id)));
        return cube.toString();
    }

    /**
     * Finds rooms with cube smaller or equal to specified limit level.
     *
     * @param level the specified cube limit level
     * @return ids of locations within limited cube level
     */
    public String findRoomsWithLimitedCubeLevel(String level) throws JSONException {
        JSONObject rooms = new JSONObject();
        rooms.put("rooms", building.findRoomsWithLimitedCubeLevel(level));
        return rooms.toString();
    }

    /**
     * Counts total heating of the building.
     *
     * @return heating of the building
     */
    public String calculateTotalHeating() throws JSONException {
        JSONObject heating = new JSONObject();
        heating.put("heating", String.valueOf(building.countTotalHeating()/building.countTotalCube()));
        return heating.toString();
    }

    /**
     * Counts heating of the location specified by id.
     *
     * @param id the id of the required location
     * @return heating of the location specified by id
     */
    public String calculateHeatingById(String id) throws JSONException {
        JSONObject heating = new JSONObject();
        heating.put("heating", String.valueOf(building.countHeatingById(id)/building.countCubeById(id)));
        return heating.toString();
    }

    /**
     * Finds rooms with heating exceeding specified level.
     *
     * @param level the specified heating level
     * @return ids of locations exceeding specified heating level
     */
    public String findRoomsWithExceededHeatingLevel(String level) throws JSONException {
        JSONObject rooms = new JSONObject();
        rooms.put("rooms", building.findRoomsWithExceededHeatingLevel(level));
        return rooms.toString();
    }

    /**
     * Finds rooms with heating smaller or equal to specified limit level.
     *
     * @param level the specified heating limit level
     * @return ids of locations within limited heating level
     */
    public String findRoomsWithLimitedHeatingLevel(String level) throws JSONException {
        JSONObject rooms = new JSONObject();
        rooms.put("rooms", building.findRoomsWithLimitedHeatingLevel(level));
        return rooms.toString();
    }

    /**
     * Counts total light of the building.
     *
     * @return light of the building
     */
    public String calculateTotalLight() throws JSONException {
        JSONObject light = new JSONObject();
        light.put("light", String.valueOf(building.countTotalLight()));
        return light.toString();
    }

    /**
     * Counts light of the location specified by id.
     *
     * @param id the id of the required location
     * @return light of the location specified by id
     */
    public String calculateLightById(String id) throws JSONException {
        JSONObject light = new JSONObject();
        light.put("light", String.valueOf(building.countLightById(id)));
        return light.toString();
    }

    /**
     * Finds rooms with light smaller or equal to specified limit level.
     *
     * @param level the specified light limit level
     * @return ids of locations within limited light level
     */
    public String findRoomsWithLimitedLightLevel(String level) throws JSONException {
        JSONObject rooms = new JSONObject();
        rooms.put("rooms", building.findRoomsWithLimitedLightLevel(level));
        return rooms.toString();
    }
}