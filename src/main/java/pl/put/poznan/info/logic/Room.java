package pl.put.poznan.info.logic;
/**
 * This is the Room class, declare the parameters of room
 */
public class Room extends Location{ // Leaf class
    private int area;
    private int cube;
    private float heating;
    private int light;

    Room(String id, String name, int area, int cube, float heating, int light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
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

    public void setArea(int area) { this.area = area; }
    public void setCube(int cube) { this.cube = cube; }
    public void setHeating(float heating) { this.heating = heating; }
    public void setLight(int light) { this.light = light; }

    @Override
    public int countTotalArea() {
        return area;
    }

    @Override
    public int countAreaById(String id) {
        if (this.getId().equals(id)){
            return area;
        }
        return 0;
    }

    @Override
    public int countTotalCube() {
        return cube;
    }

    @Override
    public int countCubeById(String id) {
        if (this.getId().equals(id)){
            return cube;
        }
        return 0;
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
        return light;
    }

    @Override
    public int countLightById(String id) {
        if (this.getId().equals(id)){
            return light;
        }
        return 0;
    }
}
