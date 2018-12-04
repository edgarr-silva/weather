package com.edgar.web.service;

import com.edgar.business.service.ClimateService;
import com.edgar.data.entity.Climate;
import com.edgar.web.application.ClimateController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ClimateServiceController.class)
public class ClimateServiceControllerTest {

    @MockBean
    private ClimateService climateService;

    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getClimateDetail() throws Exception {

        Date date1 = DATE_FORMAT.parse("2018-10-04");
        Climate mockClimate = new Climate();
        mockClimate.setStationName("StationName_test_API");
        mockClimate.setDate(date1);
        mockClimate.setMeanTemp(2.5);

        given(climateService.getClimateDetail(21L)).willReturn(mockClimate);
        mockMvc.perform(get("/api/climate/21")).andExpect(status().isOk()).andExpect(content()
                .string(containsString("{\"id\":0,\"stationName\":\"StationName_test_API\",\"province\":null,\"date\":\"2018-10-04T04:00:00.000+0000\",\"meanTemp\":2.5,\"highestMonthlyMaxiTemp\":null,\"lowestMonthlyMinTemp\":null}")));

    }
}