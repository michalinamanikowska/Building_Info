package pl.put.poznan.info.logic;

import java.util.ArrayList;
import java.util.List;

public class MidLocation extends Location{ // Composite class
    private List<Location> locations;

    MidLocation(String id, String name) {
        super(id, name);
        this.locations = new ArrayList<>();
    }

    @Override
    public int countTotalArea() {
        int area = 0;
        for (Location l : locations){
            area += l.countTotalArea();
        }
        return area;
    }

    @Override
    public int countAreaById(String id) {
        int area = 0;
        for (Location l : locations){
            if (l.getId().equals(id)){
                return l.countTotalArea();
            }
            else {
                area += l.countAreaById(id);
            }
        }
        return area;
    }

    @Override
    public int countTotalCube() {
        int cube = 0;
        for (Location l : locations){
            cube += l.countTotalCube();
        }
        return cube;
    }

    @Override
    public int countCubeById(String id) {
        int cube = 0;
        for (Location l : locations){
            if (l.getId().equals(id)){
                return l.countTotalCube();
            }
            else {
                cube += l.countCubeById(id);
            }
        }
        return cube;
    }

    @Override
    public float countTotalHeating() {
        return 0; // TODO
    }

    @Override
    public int countHeatingById(String id) {
        return 0; // TODO
    }

    @Override
    public int countTotalLight() {
        int light = 0;
        for (Location l : locations){
            light += l.countTotalLight();
        }
        return light;
    }

    @Override
    public int countLightById(String id) {
        int light = 0;
        for (Location l : locations){
            if (l.getId().equals(id)){
                return l.countTotalLight();
            }
            else {
                light += l.countLightById(id);
            }
        }
        return light;
    }

    public List<Location> getLocations() { return locations; }

    public void setLocations(List<Location> locations) { this.locations = locations; }

    public void addLocation(Location location) {
        locations.add(location);
    }
}
