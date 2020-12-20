package pl.put.poznan.info.logic;

/**
 * This is the Level class, declare the parameters of level.
 */
public class Level {
    private String id;
    private String name;
    private Room[] rooms;

    /**
     * @return id of the level
     */
    public String getId() { return id; }
    /**
     * @return name of the level
     */
    public String getName() { return name; }
    /**
     * @return array of rooms
     */
    public Room[] getRooms() { return rooms; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRooms(Room[] rooms) { this.rooms = rooms; }
}
