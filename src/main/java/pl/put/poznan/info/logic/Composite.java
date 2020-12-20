package pl.put.poznan.info.logic;

public class Composite<Loc extends Location> extends Location{ // Composite class
    private Loc[] locations;

    Composite(String id, String name, Loc[] locations) {
        super(id, name);
        this.locations = locations;
    }

    public Loc[] getLocations() { return locations; }
    public void setLocations(Loc[] locations) { this.locations = locations; }

    @Override
    public int countArea() {
        int area = 0;
        for (Loc l : locations){
            area += l.countArea();
        }
        return area;
    }

    @Override
    public int countCube() {
        int cube = 0;
        for (Loc l : locations){
            cube += l.countCube();
        }
        return cube;
    }

    @Override
    public float countHeating() {
        return 0; // TODO
    }

    @Override
    public int countLight() {
        int light = 0;
        for (Loc l : locations){
            light += l.countLight();
        }
        return light;
    }
}
