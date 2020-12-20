package pl.put.poznan.info.logic;

/**
 * This is the Level class, declare the parameters of level.
 */
public class Level extends Composite<Room>{

    Level(String id, String name, Room[] rooms) {
        super(id, name, rooms);
    }
}
