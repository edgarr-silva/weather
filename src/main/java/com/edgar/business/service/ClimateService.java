package com.edgar.business.service;

import com.edgar.data.entity.Climate;
import com.edgar.data.repository.ClimateRepository;
import com.edgar.exception.DateRangeException;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClimateService {

    private final ClimateRepository climateRepository;

    @Autowired
    public ClimateService(ClimateRepository climateRepository) {
        this.climateRepository = climateRepository;
    }

    public List<Climate> getClimatesBetweenDates(Date date1, Date date2) throws DateRangeException {

        if(date1.after(date2)){
            LogManager.getRootLogger().info("getClimatesBetweenDates - Start date cannot be bigger then end date!");
            throw new DateRangeException();
        }

        LogManager.getRootLogger().info("CALL  getClimatesBetweenDates");
        List<Climate> climates = climateRepository.findByDateGreaterThanEqualAndDateLessThanEqual(date1,date2);

        return climates;
    }

    public Climate getClimateDetail(Long id){

        LogManager.getRootLogger().info("CALL  getClimatesBetweenDates");
        Optional<Climate> climateOptional = climateRepository.findById(id);

        if(climateOptional.isPresent()){
            return climateOptional.get();
        }
        LogManager.getRootLogger().info("CALL  getClimatesBetweenDates");

        return null;
    }
}
