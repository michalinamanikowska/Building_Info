package pl.put.poznan.info.rest;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

@RestController
public class BuildingInfoLightController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoLightController.class);

    @RequestMapping(value = "light/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingLight(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String light = informer.calculateTotalLight();
        logger.debug("Light:" + light);
        return light;
    }

    @RequestMapping(value = "light/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelLight(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String light = informer.calculateLightById(id);
        logger.debug("Light:" + light);
        return light;
    }

    @RequestMapping(value = "light/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomLight(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String light = informer.calculateLightById(id);
        logger.debug("Light:" + light);
        return light;
    }
}