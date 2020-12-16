package pl.put.poznan.info.logic;

public class Level {
    private String id;
    private String name;
    private Room[] rooms;

    public String getId() { return id; }
    public String getName() { return name; }
    public Room[] getRooms() { return rooms; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRooms(Room[] rooms) { this.rooms = rooms; }
}
