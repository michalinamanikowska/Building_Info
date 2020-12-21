package pl.put.poznan.info.logic;

public abstract class Location { // Base Component class
    private String id;
    private String name;

    public Location(String id, String name) {
        this.id = id;
        this.name = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int countTotalArea();
    public abstract int countAreaById(String id);
    public abstract int countTotalCube();
    public abstract int countCubeById(String id);
    public abstract float countTotalHeating();
    public abstract int countHeatingById(String id);
    public abstract int countTotalLight();
    public abstract int countLightById(String id);

    public abstract int accept(LocationVisitor visitor);
}
