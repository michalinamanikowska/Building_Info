package pl.put.poznan.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfoArea;


@RestController
public class BuildingInfoAreaController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoAreaController.class);

    @RequestMapping(value = "area/building", method = RequestMethod.POST, produces = "application/json")
    public String buildingArea(@RequestBody String info) {

        logger.debug(info);

        BuildingInfoArea informer = new BuildingInfoArea(info);
        return informer.calculateBuilding();
    }

    @RequestMapping(value = "area/level/{id}", method = RequestMethod.POST, produces = "application/json")
    public String levelArea(@RequestBody String info, @PathVariable String id) {

        logger.debug(info);

        BuildingInfoArea informer = new BuildingInfoArea(info);
        return informer.calculateLevel(id);
    }

    @RequestMapping(value = "area/room/{id}", method = RequestMethod.POST, produces = "application/json")
    public String roomArea(@RequestBody String info, @PathVariable String id) {

        logger.debug(info);

        BuildingInfoArea informer = new BuildingInfoArea(info);
        return informer.calculateRoom(id);
    }
}


