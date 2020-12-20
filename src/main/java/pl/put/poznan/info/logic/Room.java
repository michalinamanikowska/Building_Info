package pl.put.poznan.info.logic;
/**
 * This is the Room class, declare the parameters of room
 */
public class Room {
    private String id;
    private String name;
    private int area;
    private int cube;
    private float heating;
    private int light;
    /**
     * @return id of the room
     */
    public String getId() { return id; }
    /**
     * @return name of the room
     */
    public String getName() { return name; }
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

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setArea(int area) { this.area = area; }
    public void setCube(int cube) { this.cube = cube; }
    public void setHeating(float heating) { this.heating = heating; }
    public void setLight(int light) { this.light = light; }
}
