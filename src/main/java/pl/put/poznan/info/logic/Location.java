package pl.put.poznan.info.logic;

public abstract class Location { // Base Component class
    private String id;
    private String name;

    Location(String id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * @return id of the location
     */
    public String getId(){ return id; }

    /**
     * @return name of the location
     */
    public String getName() { return name; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public abstract int countArea();
    public abstract int countCube();
    public abstract float countHeating();
    public abstract int countLight();
}
