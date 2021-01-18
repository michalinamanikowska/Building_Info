package pl.put.poznan.info.rest;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;


@RestController
public class BuildingInfoHeatingController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoHeatingController.class);

    @RequestMapping(value = "heating/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingHeating(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String heating = informer.calculateTotalHeating();
        logger.debug("Heating: " + heating);
        return heating;
    }

    @RequestMapping(value = "heating/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelHeating(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Level id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String heating = informer.calculateHeatingById(id);
        logger.debug("Heating: " + heating);
        return heating;
    }

    @RequestMapping(value = "heating/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomHeating(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Room id: " + id);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String heating = informer.calculateHeatingById(id);
        logger.debug("Heating: " + heating);
        return heating;
    }

    @RequestMapping(value = "heating/exceed/{level}", method = RequestMethod.POST, produces = "application/json")
    public String exceededHeating(@RequestBody String buildingData, @PathVariable String level) throws JSONException {

        logger.debug(buildingData);
        logger.debug("Limit level: " + level);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String rooms = informer.findRoomsWithExceededHeatingLevel(level);
        logger.debug("Rooms with exceeded heating level: " + rooms);
        // TODO functions return json not string
        return rooms;
    }
}


