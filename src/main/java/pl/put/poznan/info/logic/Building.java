package pl.put.poznan.info.logic;
/**
 * This is the Building class, declare the parameters of building.
 */
public class Building {
    private String id;
    private String name;
    private Level[] levels;

    /**
     * @return id of the builing
     */
    public String getId() { return id; }
    /**
     * @return name of the builing
     */
    public String getName() { return name; }
    /**
     * @return array of levels
     */
    public Level[] getLevels() { return levels; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLevels(Level[] levels) { this.levels = levels; }
}
