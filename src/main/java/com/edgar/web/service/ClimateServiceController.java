package com.edgar.web.service;

import com.edgar.business.service.ClimateService;
import com.edgar.data.entity.Climate;
import com.edgar.exception.ClimateNotFoundException;
import com.edgar.exception.DateRangeException;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClimateServiceController {

    @Autowired
    private ClimateService climateService;

    @RequestMapping(value = "/climate",method= RequestMethod.GET)
    public List<Climate> getClimates(@RequestParam(required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                                     @RequestParam(required=false) @DateTimeFormat(pattern = "yyyy-MM-dd")Date date2) throws DateRangeException{
        List<Climate> climates = new ArrayList<>();

        if(null!=date1&& null!=date2){
            climates = climateService.getClimatesBetweenDates(date1,date2);
        }
        return climates;
    }


    @RequestMapping(value = "/climate/{id}",method= RequestMethod.GET)
    public Climate getClimateDetail(@PathVariable(required=true) Long id){
        Climate climate;
        climate = climateService.getClimateDetail(id);

        if(null==climate){
            LogManager.getRootLogger().info("API getClimateDetail climate not found id: "+ id);

            throw new ClimateNotFoundException();
        }
        return climate;
    }
}
