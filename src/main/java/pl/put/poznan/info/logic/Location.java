package pl.put.poznan.info.logic;

/**
 * This is the Location abstract class, which acts as the Base Component class of the Composite pattern.
 */
public abstract class Location {
    private String id;
    private String name;

    /**
     * Instantiates a new Location.
     *
     * @param id   the identifier of the location
     * @param name the name of the location
     */
    public Location(String id, String name) {
        this.id = id;
        this.name = id;
    }

    /**
     * Gets identifier of the location
     *
     * @return identifier of the location
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the new identifier for the location
     *
     * @param id the identifier of the location
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name of the location
     *
     * @return name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the new name of the location
     *
     * @param name the name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Counts total area of the location.
     *
     * @return total area of the location
     */
    public abstract int countTotalArea();

    /**
     * Counts area of the location specified by id.
     *
     * @param id the identifier of the location
     * @return area of the location
     */
    public abstract int countAreaById(String id);

    /**
     * Counts total cube of the location.
     *
     * @return total cube of the location
     */
    public abstract int countTotalCube();

    /**
     * Counts cube of the location specified by id.
     *
     * @param id the identifier of the location
     * @return cube of the location
     */
    public abstract int countCubeById(String id);

    /**
     * Counts total heating of the location.
     *
     * @return total heating of the location
     */
    public abstract float countTotalHeating();

    /**
     * Counts heating of the location specified by id.
     *
     * @param id the identifier of the location
     * @return heating of the location
     */
    public abstract int countHeatingById(String id);

    /**
     * Counts total light of the location.
     *
     * @return total light of the location
     */
    public abstract int countTotalLight();

    /**
     * Counts light of the location specified by id.
     *
     * @param id the identifier of the location
     * @return light of the location
     */
    public abstract int countLightById(String id);
}