package com.edgar.data.repository;

import com.edgar.data.entity.Climate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ClimateRepository extends JpaRepository<Climate,Long> {

public List<Climate> findByDateGreaterThanEqualAndDateLessThanEqual(Date date1, Date date2);
}
