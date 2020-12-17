package pl.put.poznan.info.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfoLight;

@RestController
public class BuildingInfoLightController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoLightController.class);

    @RequestMapping(value = "light/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingLight(@RequestBody String info) {

        logger.debug(info);

        BuildingInfoLight informer = new BuildingInfoLight(info);
        return informer.calculateBuildingLight();
    }

    @RequestMapping(value = "light/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelLight(@RequestBody String info, @PathVariable String id) {

        logger.debug(info);

        BuildingInfoLight informer = new BuildingInfoLight(info);
        return informer.calculateLevelLight(id);
    }

    @RequestMapping(value = "light/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomLight(@RequestBody String info, @PathVariable String id) {

        logger.debug(info);

        BuildingInfoLight informer = new BuildingInfoLight(info);
        return informer.calculateRoomLight(id);
    }
}