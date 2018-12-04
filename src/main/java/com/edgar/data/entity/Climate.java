package com.edgar.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "climate")
public class Climate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "station_name")
    private  String stationName;
    @Column(name = "province")
    private String province;
    @Column(name = "date")
    private Date date;
    @Column(name = "mean_temp")
    private  Double meanTemp;
    @Column(name = "highest_monthly_maxi_temp")
    private  Double highestMonthlyMaxiTemp;
    @Column(name = "lowest_monthly_min_temp")
    private  Double lowestMonthlyMinTemp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMeanTemp() {
        return meanTemp;
    }

    public void setMeanTemp(Double meanTemp) {
        this.meanTemp = meanTemp;
    }

    public Double getHighestMonthlyMaxiTemp() {
        return highestMonthlyMaxiTemp;
    }

    public void setHighestMonthlyMaxiTemp(Double highestMonthlyMaxiTemp) {
        this.highestMonthlyMaxiTemp = highestMonthlyMaxiTemp;
    }

    public Double getLowestMonthlyMinTemp() {
        return lowestMonthlyMinTemp;
    }

    public void setLowestMonthlyMinTemp(Double lowestMonthlyMinTemp) {
        this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
    }
}
