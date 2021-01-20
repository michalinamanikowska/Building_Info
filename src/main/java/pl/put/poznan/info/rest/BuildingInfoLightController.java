package pl.put.poznan.info.rest;

import org.json.JSONException;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

/**
 * This is the BuildingInfoLightController class, which contains endpoints returning data about the building light.
 */
@RestController
public class BuildingInfoLightController {
    /**
     * the logger attribute which logs light info about app execution at the DEBUG and INFO levels
     */
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoLightController.class);

    /**
     * Endpoint finding total light of the building.
     *
     * @param buildingData the building data in json format
     * @return light of the building
     */
    @RequestMapping(value = "light/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingLight(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String light = informer.calculateTotalLight();
        logger.debug("Light: " + light);
        return light;
    }

    /**
     * Endpoint finding light of the level specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required level
     * @return light of the level specified by id
     */
    @RequestMapping(value = "light/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelLight(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Level id: " + id);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String light = informer.calculateLightById(id);
        logger.debug("Light: " + light);
        return light;
    }

    /**
     * Endpoint finding light of the room specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required room
     * @return light of the room specified by id
     */
    @RequestMapping(value = "light/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomLight(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Room id: " + id);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String light = informer.calculateLightById(id);
        logger.debug("Light: " + light);
        return light;
    }

    /**
     * Endpoint finding rooms with light smaller or equal to specified limit level.
     *
     * @param buildingData the building data in json format
     * @param level the specified light limit level
     * @return ids of rooms within limited light level
     */
    @RequestMapping(value = "light/limit/{level}", method = RequestMethod.POST, produces = "application/json")
    public String limitedLight(@RequestBody String buildingData, @PathVariable String level) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Limit level: " + level);

        BuildingInfo informer;
        try { informer = new BuildingInfo(buildingData); }
        catch ( JSONException e ) {
            return "Query body badly formatted!";
        }

        String rooms = informer.findRoomsWithLimitedLightLevel(level);
        logger.debug("Rooms with limited light level: " + rooms);
        return rooms;
    }
}