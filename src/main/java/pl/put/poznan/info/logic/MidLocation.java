package pl.put.poznan.info.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the MidLocation class, which acts as the Composite class of the Composite pattern.
 */
public class MidLocation extends Location {
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
    public String findRoomsWithLimitedAreaLevel(String level){
        ArrayList<String> rooms = new ArrayList<>();
        for (Location l : locations) {
            String found = l.findRoomsWithLimitedAreaLevel(level);
            if (!found.isEmpty()) { rooms.add(found); }
        }
        return String.join(",", rooms);
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
    public String findRoomsWithLimitedCubeLevel(String level){
        ArrayList<String> rooms = new ArrayList<>();
        for (Location l : locations) {
            String found = l.findRoomsWithLimitedCubeLevel(level);
            if (!found.isEmpty()) { rooms.add(found); }
        }
        return String.join(",", rooms);
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
    public String findRoomsWithExceededHeatingLevel(String level){
        ArrayList<String> rooms = new ArrayList<>();
        for (Location l : locations) {
            String found = l.findRoomsWithExceededHeatingLevel(level);
            if (!found.isEmpty()) { rooms.add(found); }
        }
        return String.join(",", rooms);
    }

    @Override
    public String findRoomsWithLimitedHeatingLevel(String level){
        ArrayList<String> rooms = new ArrayList<>();
        for (Location l : locations) {
            String found = l.findRoomsWithLimitedHeatingLevel(level);
            if (!found.isEmpty()) { rooms.add(found); }
        }
        return String.join(",", rooms);
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
    public String findRoomsWithLimitedLightLevel(String level){
        ArrayList<String> rooms = new ArrayList<>();
        for (Location l : locations) {
            String found = l.findRoomsWithLimitedLightLevel(level);
            if (!found.isEmpty()) { rooms.add(found); }
        }
        return String.join(",", rooms);
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
