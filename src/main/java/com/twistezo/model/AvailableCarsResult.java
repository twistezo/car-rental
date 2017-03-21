package com.twistezo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author twistezo (03.03.2017)
 */
public class AvailableCarsResult implements Serializable {
    private static final long serialVersionUID = 3209915747110932732L;

    public AvailableCarsResult(Long id, Long carId, String carName, String carDescription, BigDecimal carPrice) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.carDescription = carDescription;
        this.carPrice = carPrice;
    }

    private Long id;
    private Long carId;
    private String carName;
    private String carDescription;
    private BigDecimal carPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }
}
