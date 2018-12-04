package com.edgar.web.application;

import com.edgar.business.service.ClimateService;
import com.edgar.data.entity.Climate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ClimateController.class)
public class ClimateControllerTest{

        @MockBean
        private ClimateService climateService;
        @Autowired
        private MockMvc mockMvc;

        private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

        @Test
        public void getClimates() throws Exception{
            List<Climate> mockClimateList = new ArrayList<>();
            Date date1 = DATE_FORMAT.parse("2018-10-04");
            Date date2 = DATE_FORMAT.parse("2018-10-04");
            Climate mockClimate = new Climate();
            mockClimate.setStationName("StationName_test");
            mockClimate.setDate(date1);
            mockClimate.setMeanTemp(2.5);

            mockClimateList.add(mockClimate);

            given(climateService.getClimatesBetweenDates(date1,date2)).willReturn(mockClimateList);
            mockMvc.perform(get("/climate?date1=2018-10-04&date2=2018-10-04")).andExpect(status().isOk()).andExpect(content().string(containsString("StationName_test")));
        }

}