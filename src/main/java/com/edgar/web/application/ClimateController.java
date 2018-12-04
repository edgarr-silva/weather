package com.edgar.web.application;

import com.edgar.business.service.ClimateService;
import com.edgar.data.entity.Climate;
import com.edgar.exception.DateRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/climate")
public class ClimateController {

        @Autowired
        private ClimateService climateService;


    @RequestMapping(method= RequestMethod.GET)
    public String getClimates(@RequestParam(required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                          @RequestParam(required=false) @DateTimeFormat(pattern = "yyyy-MM-dd")Date date2,
                          Model model) throws DateRangeException {

        if(null!=date1&& null!=date2){
            List<Climate> climates;
            climates = climateService.getClimatesBetweenDates(date1,date2);
            model.addAttribute("climates",climates);
        }

        return "climate";
    }

    @RequestMapping(value = "/detail",method= RequestMethod.GET)
    public String getClimateDetail(@RequestParam(required=true) Long id,
                              Model model){

            Climate climates;
            climates = climateService.getClimateDetail(id);
            model.addAttribute("climate",climates);

        return "climateDetail";
    }
}
