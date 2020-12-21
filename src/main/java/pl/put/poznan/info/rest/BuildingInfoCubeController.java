package pl.put.poznan.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;


@RestController
public class BuildingInfoCubeController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoCubeController.class);

    @RequestMapping(value = "cube/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingCube(@RequestBody String buildingData) {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo();
        return informer.calculateTotalCube();
    }

    @RequestMapping(value = "cube/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelCube(@RequestBody String buildingData, @PathVariable String id) {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo();
        return informer.calculateCubeById(id);
    }

    @RequestMapping(value = "cube/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomCube(@RequestBody String buildingData, @PathVariable String id) {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo();
        return informer.calculateCubeById(id);
    }
}


