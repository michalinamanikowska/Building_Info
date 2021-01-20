package pl.put.poznan.info.rest;

import org.json.JSONException;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

/**
 * This is the BuildingInfoHeatingController class, which contains endpoints returning data about the building heating.
 */
@RestController
public class BuildingInfoHeatingController {
    /**
     * the logger attribute which logs heating info about app execution at the DEBUG and INFO levels
     */
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoHeatingController.class);

    /**
     * Endpoint finding total heating of the building.
     *
     * @param buildingData the building data in json format
     * @return heating of the building
     */
    @RequestMapping(value = "heating/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingHeating(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String heating = informer.calculateTotalHeating();
        logger.debug("Heating: " + heating);
        return heating;
    }

    /**
     * Endpoint finding heating of the level specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required level
     * @return heating of the level specified by id
     */
    @RequestMapping(value = "heating/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelHeating(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Level id: " + id);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String heating = informer.calculateHeatingById(id);
        logger.debug("Heating: " + heating);
        return heating;
    }

    /**
     * Endpoint finding heating of the room specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required room
     * @return heating of the room specified by id
     */
    @RequestMapping(value = "heating/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomHeating(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Room id: " + id);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String heating = informer.calculateHeatingById(id);
        logger.debug("Heating: " + heating);
        return heating;
    }

    /**
     * Endpoint finding rooms with heating greater than specified level.
     *
     * @param buildingData the building data in json format
     * @param level the specified heating level
     * @return ids of rooms exceeding specified heating level
     */
    @RequestMapping(value = "heating/exceed/{level}", method = RequestMethod.POST, produces = "application/json")
    public String exceededHeating(@RequestBody String buildingData, @PathVariable String level) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Limit level: " + level);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String rooms = informer.findRoomsWithExceededHeatingLevel(level);
        logger.debug("Rooms with exceeded heating level: " + rooms);
        // TODO functions return json not string
        return rooms;
    }

    /**
     * Endpoint finding rooms with heating smaller or equal to specified limit level.
     *
     * @param buildingData the building data in json format
     * @param level the specified heating limit level
     * @return ids of rooms within limited heating level
     */
    @RequestMapping(value = "heating/limit/{level}", method = RequestMethod.POST, produces = "application/json")
    public String limitedHeating(@RequestBody String buildingData, @PathVariable String level) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Limit level: " + level);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String rooms = informer.findRoomsWithLimitedHeatingLevel(level);
        logger.debug("Rooms with limited heating level: " + rooms);
        return rooms;
    }
}


