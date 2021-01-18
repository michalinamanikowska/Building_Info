package pl.put.poznan.info.rest;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;


@RestController
public class BuildingInfoAreaController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoAreaController.class);

    @RequestMapping(value = "area/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingArea(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String area = informer.calculateTotalArea();
        logger.debug("Area: " + area);
        return area;
    }

    @RequestMapping(value = "area/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelArea(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Level id: " + id);


        BuildingInfo informer = new BuildingInfo(buildingData);
        String area = informer.calculateAreaById(id);
        logger.debug("Area: " + area);
        return area;
    }

    @RequestMapping(value = "area/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomArea(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Room id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String area = informer.calculateAreaById(id);
        logger.debug("Area:" + area);
        return area;
    }

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


