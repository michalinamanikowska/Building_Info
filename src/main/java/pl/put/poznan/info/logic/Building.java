package pl.put.poznan.info.logic;
/**
 * This is the Building class, declare the parameters of building.
 */
public class Building extends Location{ // Composite class
    private Level[] levels;

    Building(String id, String name) {
        super(id, name);
    }

    /**
     * @return array of levels
     */
    public Level[] getLevels() { return levels; }
    public void setLevels(Level[] levels) { this.levels = levels; }

    @Override
    public int countArea() {
        int area = 0;
        for (Level l : levels) {
            area += l.countArea();
        }
        return area;
    }

    @Override
    public int countCube() {
        int cube = 0;
        for (Level l : levels) {
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
        for (Level l : levels) {
            light += l.countLight();
        }
        return light;
    }
}
