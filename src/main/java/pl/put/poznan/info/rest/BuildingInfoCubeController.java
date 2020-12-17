package pl.put.poznan.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfoCube;


@RestController
public class BuildingInfoCubeController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoCubeController.class);

    @RequestMapping(value = "cube/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingCube(@RequestBody String info) {

        logger.debug(info);

        BuildingInfoCube informer = new BuildingInfoCube(info);
        return informer.calculateBuildingCube();
    }

    @RequestMapping(value = "cube/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelCube(@RequestBody String info, @PathVariable String id) {

        logger.debug(info);

        BuildingInfoCube informer = new BuildingInfoCube(info);
        return informer.calculateLevelCube(id);
    }

    @RequestMapping(value = "cube/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomCube(@RequestBody String info, @PathVariable String id) {

        logger.debug(info);

        BuildingInfoCube informer = new BuildingInfoCube(info);
        return informer.calculateRoomCube(id);
    }
}


