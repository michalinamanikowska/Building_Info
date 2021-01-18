package pl.put.poznan.info.rest;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

/**
 * This is the BuildingInfoAreaController class, which contains endpoints returning data about the building area.
 */
@RestController
public class BuildingInfoAreaController {
    /**
     * the logger attribute which logs area info about app execution at the DEBUG and INFO levels
     */
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoAreaController.class);

    /**
     * Endpoint finding total area of the building.
     *
     * @param buildingData the building data in json format
     * @return area of the building
     */
    @RequestMapping(value = "area/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingArea(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String area = informer.calculateTotalArea();
        logger.debug("Area: " + area);
        return area;
    }

    /**
     * Endpoint finding area of the level specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required level
     * @return area of the level specified by id
     */
    @RequestMapping(value = "area/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelArea(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Level id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String area = informer.calculateAreaById(id);
        logger.debug("Area: " + area);
        return area;
    }

    /**
     * Endpoint finding area of the room specified by id.
     *
     * @param buildingData the building data in json format
     * @param id the identifier of the required room
     * @return area of the room specified by id
     */
    @RequestMapping(value = "area/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomArea(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Room id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String area = informer.calculateAreaById(id);
        logger.debug("Area:" + area);
        return area;
    }

    /**
     * Endpoint finding rooms with area smaller or equal to specified limit level.
     *
     * @param buildingData the building data in json format
     * @param level the specified area limit level
     * @return ids of rooms within limited area level
     */
    @RequestMapping(value = "area/limit/{level}", method = RequestMethod.POST, produces = "application/json")
    public String limitedArea(@RequestBody String buildingData, @PathVariable String level) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Limit level: " + level);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String rooms = informer.findRoomsWithLimitedAreaLevel(level);
        logger.debug("Rooms with limited area level: " + rooms);
        return rooms;
    }
}


