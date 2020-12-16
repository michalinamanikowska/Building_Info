package pl.put.poznan.info.logic;

public class Building {
    private String id;
    private String name;
    private Level[] levels;

    public String getId() { return id; }
    public String getName() { return name; }
    public Level[] getLevels() { return levels; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLevels(Level[] levels) { this.levels = levels; }
}
