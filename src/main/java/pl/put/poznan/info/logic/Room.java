package pl.put.poznan.info.logic;

public class Room {
    private String id;
    private String name;
    private int area;
    private int cube;
    private float heating;
    private int light;

    public String getId() { return id; }
    public String getName() { return name; }
    public int getArea() { return area; }
    public int getCube() { return cube; }
    public float getHeating() { return heating; }
    public int getLight() { return light; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setArea(int area) { this.area = area; }
    public void setCube(int cube) { this.cube = cube; }
    public void setHeating(float heating) { this.heating = heating; }
    public void setLight(int light) { this.light = light; }
}
