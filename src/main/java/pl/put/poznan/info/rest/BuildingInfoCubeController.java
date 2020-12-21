package pl.put.poznan.info.rest;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;


@RestController
public class BuildingInfoCubeController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoCubeController.class);

    @RequestMapping(value = "cube/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingCube(@RequestBody String buildingData) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String cube = informer.calculateTotalCube();
        logger.debug("Cube:" + cube);
        return cube;
    }

    @RequestMapping(value = "cube/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelCube(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String cube = informer.calculateCubeById(id);
        logger.debug("Cube:" + cube);
        return cube;
    }

    @RequestMapping(value = "cube/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomCube(@RequestBody String buildingData, @PathVariable String id) throws JSONException {

        logger.debug(buildingData);

        BuildingInfo informer = new BuildingInfo(buildingData);
        String cube = informer.calculateCubeById(id);
        logger.debug("Cube:" + cube);
        return cube;
    }
}


