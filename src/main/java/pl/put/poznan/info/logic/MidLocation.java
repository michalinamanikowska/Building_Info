package pl.put.poznan.info.logic;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the MidLocation class, which acts as the Composite class of the Composite pattern.
 */
public class MidLocation extends Location {
    /**
     * the list of locations
     */
    private List<Location> locations;

    /**
     * Instantiates a new MidLocation.
     *
     * @param id   the identifier of the location
     * @param name the name of the location
     */
    MidLocation(String id, String name) {
        super(id, name);
        this.locations = new ArrayList<>();
    }

    @Override
    public int countTotalArea() {
        int area = 0;
        for (Location l : locations) {
            area += l.countTotalArea();
        }
        return area;
    }

    @Override
    public int countAreaById(String id) {
        int area = 0;
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                return l.countTotalArea();
            } else {
                area += l.countAreaById(id);
            }
        }
        return area;
    }

    @Override
    public JSONArray findRoomsWithLimitedAreaLevel(String level) throws JSONException {
        JSONArray rooms = new JSONArray();
        for (Location l : locations) {
            JSONArray ids = l.findRoomsWithLimitedAreaLevel(level);
            for (int i = 0; i < ids.length(); i++) {
                rooms.put(ids.getJSONObject(i));
            }
        }
        return rooms;
    }

    @Override
    public int countTotalCube() {
        int cube = 0;
        for (Location l : locations) {
            cube += l.countTotalCube();
        }
        return cube;
    }

    @Override
    public int countCubeById(String id) {
        int cube = 0;
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                return l.countTotalCube();
            } else {
                cube += l.countCubeById(id);
            }
        }
        return cube;
    }

    @Override
    public JSONArray findRoomsWithLimitedCubeLevel(String level) throws JSONException {
        JSONArray rooms = new JSONArray();
        for (Location l : locations) {
            JSONArray ids = l.findRoomsWithLimitedCubeLevel(level);
            for (int i = 0; i < ids.length(); i++) {
                rooms.put(ids.getJSONObject(i));
            }
        }
        return rooms;
    }

    @Override
    public float countTotalHeating() {
        float heating = 0;
        for (Location l : locations) {
            heating += l.countTotalHeating();
        }
        return heating;
    }

    @Override
    public float countHeatingById(String id) {
        float heating = 0;
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                return l.countTotalHeating();
            } else {
                heating += l.countHeatingById(id);
            }
        }
        return heating;
    }

    @Override
    public JSONArray findRoomsWithExceededHeatingLevel(String level) throws JSONException {
        JSONArray rooms = new JSONArray();
        for (Location l : locations) {
            JSONArray ids = l.findRoomsWithExceededHeatingLevel(level);
            for (int i = 0; i < ids.length(); i++) {
                rooms.put(ids.getJSONObject(i));
            }
        }
        return rooms;
    }

    @Override
    public JSONArray findRoomsWithLimitedHeatingLevel(String level) throws JSONException {
        JSONArray rooms = new JSONArray();
        for (Location l : locations) {
            JSONArray ids = l.findRoomsWithLimitedHeatingLevel(level);
            for (int i = 0; i < ids.length(); i++) {
                rooms.put(ids.getJSONObject(i));
            }
        }
        return rooms;
    }

    @Override
    public int countTotalLight() {
        int light = 0;
        for (Location l : locations) {
            light += l.countTotalLight();
        }
        return light;
    }

    @Override
    public int countLightById(String id) {
        int light = 0;
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                return l.countTotalLight();
            } else {
                light += l.countLightById(id);
            }
        }
        return light;
    }

    @Override
    public JSONArray findRoomsWithLimitedLightLevel(String level) throws JSONException {
        JSONArray rooms = new JSONArray();
        for (Location l : locations) {
            JSONArray ids = l.findRoomsWithLimitedLightLevel(level);
            for (int i = 0; i < ids.length(); i++) {
                rooms.put(ids.getJSONObject(i));
            }
        }
        return rooms;
    }

    /**
     * Gets the list of locations inside the location
     *
     * @return the list of all locations in this MidLocation instance
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Sets the new list of locations inside the location
     *
     * @param locations the list of locations inside the MidLocation instance
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Adds the new location to the locations list.
     *
     * @param location the new location inside the MidLocation instance
     */
    public void addLocation(Location location) {
        locations.add(location);
    }
}
