package pl.put.poznan.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="info", defaultValue="upper,escape") String[] info) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(info));

        // perform the transformation, you should run your logic here, below is just a silly example
        BuildingInfo informer = new BuildingInfo(info);
        return informer.inform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] info) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(info));

        // perform the transformation, you should run your logic here, below is just a silly example
        BuildingInfo informer = new BuildingInfo(info);
        return informer.inform(text);
    }



}


