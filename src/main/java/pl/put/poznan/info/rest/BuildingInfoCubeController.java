package pl.put.poznan.info.rest;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

/**
 * This is the BuildingInfoCubeController class, which contains endpoints returning data about the building cube.
 */
@RestController
public class BuildingInfoCubeController {
    /**
     * the logger attribute which logs cube info about app execution at the DEBUG and INFO levels
     */
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoCubeController.class);

    /**
     * Endpoint finding total cube of the building.
     *
     * @param buildingData the building data in json format
     * @return cube of the building
     */
    @RequestMapping(value = "cube/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingCube(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String cube = informer.calculateTotalCube();
        logger.debug("Cube: " + cube);
        return cube;
    }

    /**
     * Endpoint finding cube of the level specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required level
     * @return cube of the level specified by id
     */
    @RequestMapping(value = "cube/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelCube(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Level id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String cube = informer.calculateCubeById(id);
        logger.debug("Cube: " + cube);
        return cube;
    }

    /**
     * Endpoint finding cube of the room specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required room
     * @return cube of the room specified by id
     */
    @RequestMapping(value = "cube/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomCube(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Room id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String cube = informer.calculateCubeById(id);
        logger.debug("Cube: " + cube);
        return cube;
    }

    /**
     * Endpoint finding rooms with cube smaller or equal to specified limit level.
     *
     * @param buildingData the building data in json format
     * @param level the specified cube limit level
     * @return ids of rooms within limited cube level
     */
    @RequestMapping(value = "cube/limit/{level}", method = RequestMethod.POST, produces = "application/json")
    public String limitedCube(@RequestBody String buildingData, @PathVariable String level) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Limit level: " + level);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String rooms = informer.findRoomsWithLimitedCubeLevel(level);
        logger.debug("Rooms with limited cube level: " + rooms);
        return rooms;
    }
}


