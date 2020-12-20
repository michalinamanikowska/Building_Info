package pl.put.poznan.info.logic;
/**
 * This is the Room class, declare the parameters of room
 */
public class Room extends Location{ // Leaf class
    private int area;
    private int cube;
    private float heating;
    private int light;

    Room(String id, String name) {
        super(id, name);
    }

    /**
     * @return area of the room
     */
    public int getArea() { return area; }
    /**
     * @return cube of the room
     */
    public int getCube() { return cube; }
    /**
     * @return heating in the room
     */
    public float getHeating() { return heating; }
    /**
     * @return power of light in the room
     */
    public int getLight() { return light; }

    @Override
    public int countArea() {
        return 0; // this is leaf node so this method is not applicable to this class
    }

    @Override
    public int countCube() {
        return 0; // this is leaf node so this method is not applicable to this class
    }

    @Override
    public float countHeating() {
        return 0; // this is leaf node so this method is not applicable to this class
    }

    @Override
    public int countLight() {
        return 0; // this is leaf node so this method is not applicable to this class
    }

    public void setArea(int area) { this.area = area; }
    public void setCube(int cube) { this.cube = cube; }
    public void setHeating(float heating) { this.heating = heating; }
    public void setLight(int light) { this.light = light; }
}
