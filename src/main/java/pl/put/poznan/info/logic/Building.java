package pl.put.poznan.info.logic;
/**
 * This is the Building class, declare the parameters of building.
 */
public class Building extends Composite<Level>{

    Building(String id, String name, Level[] levels) {
        super(id, name, levels);
    }
}
