package com.edgar.business.service;

import com.edgar.data.entity.Climate;
import com.edgar.data.repository.ClimateRepository;
import com.edgar.exception.DateRangeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClimateServiceTest {

    @InjectMocks
    ClimateService climateService;
    @Mock
    ClimateRepository climateRepository;

    @Test
    public void getClimatesBetweenDates() throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = format.parse("2018-01-01");
        Date date2 = format.parse("2018-01-04");

        List<Climate> mockClimates = new ArrayList<>();
        mockClimates.add(new Climate());

        when(climateService.getClimatesBetweenDates(date1,date2)).thenReturn(mockClimates);
        List<Climate> climatesTest = climateService.getClimatesBetweenDates(date1,date2);
        // verification the method findByDateGreaterThanEqualAndDateLessThanEqual must be called at least one time
        verify(climateRepository,times(1)).findByDateGreaterThanEqualAndDateLessThanEqual(date1,date2);
        Assert.assertEquals(climatesTest.size(),1);
    }

    @Test(expected= DateRangeException.class)
    public void getClimatesBetweenDatesError() throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = format.parse("2018-01-04");
        Date date2 = format.parse("2018-01-01");

        when(climateService.getClimatesBetweenDates(date1,date2)).thenReturn(any());
        climateService.getClimatesBetweenDates(date1,date2);
        // verification the method findByDateGreaterThanEqualAndDateLessThanEqual must not be called
        verify(climateRepository,times(0)).findByDateGreaterThanEqualAndDateLessThanEqual(date1,date2);

    }

}