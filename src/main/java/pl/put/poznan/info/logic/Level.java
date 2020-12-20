package pl.put.poznan.info.logic;

/**
 * This is the Level class, declare the parameters of level.
 */
public class Level extends Location{ // Composite class
    private Room[] rooms;

    Level(String id, String name) {
        super(id, name);
    }

    public Room[] getRooms() { return rooms; }
    public void setRooms(Room[] rooms) { this.rooms = rooms; }

    @Override
    public int countArea() {
        int area = 0;
        for (Room r : rooms) {
            area += r.getArea();
        }
        return area;
    }

    @Override
    public int countCube() {
        int cube = 0;
        for (Room r : rooms) {
            cube += r.getCube();
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
        for (Room r : rooms) {
            light += r.getLight();
        }
        return light;
    }
}
