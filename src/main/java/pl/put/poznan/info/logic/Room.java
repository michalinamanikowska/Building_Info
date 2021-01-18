package pl.put.poznan.info.logic;

/**
 * This is the Room class, which acts as the Leaf class of the Composite pattern.
 */
public class Room extends Location {
    private int area;
    private int cube;
    private float heating;
    private int light;

    /**
     * Instantiates a new Room.
     *
     * @param id      the identifier of the room
     * @param name    the name of the room
     * @param area    the area of the room
     * @param cube    the cube of the room
     * @param heating the heating of the room
     * @param light   the light of the room
     */
    Room(String id, String name, int area, int cube, float heating, int light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * Gets area of the room
     *
     * @return area of the room
     */
    public int getArea() {
        return area;
    }

    /**
     * Sets the new area of the room
     *
     * @param area the area of the room
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * Gets cube of the room
     *
     * @return cube of the room
     */
    public int getCube() {
        return cube;
    }

    /**
     * Sets the new cube of the room
     *
     * @param cube the cube of the room
     */
    public void setCube(int cube) {
        this.cube = cube;
    }

    /**
     * Gets heating of the room
     *
     * @return heating in the room
     */
    public float getHeating() {
        return heating;
    }

    /**
     * Sets the new heating level of the room
     *
     * @param heating the heating of the room
     */
    public void setHeating(float heating) {
        this.heating = heating;
    }

    /**
     * Gets light of the room
     *
     * @return power of light in the room
     */
    public int getLight() {
        return light;
    }

    /**
     * Sets the new light power of the room
     *
     * @param light the light of the room
     */
    public void setLight(int light) {
        this.light = light;
    }

    @Override
    public int countTotalArea() {
        return area;
    }

    @Override
    public int countAreaById(String id) {
        if (this.getId().equals(id)) {
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
        if (this.getId().equals(id)) {
            return cube;
        }
        return 0;
    }

    @Override
    public float countTotalHeating() {
        return heating*cube;
    }

    @Override
    public float countHeatingById(String id) {
        if (this.getId().equals(id)) {
            return (heating*cube);
        }
        return 0;
    }

    @Override
    public int countTotalLight() {
        return light;
    }

    @Override
    public int countLightById(String id) {
        if (this.getId().equals(id)) {
            return light;
        }
        return 0;
    }
}