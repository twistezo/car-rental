package com.twistezo.service;

import com.twistezo.model.Car;

import java.util.List;

/**
 * @author twistezo (20.02.2017)
 */
public interface CarService {

    List<Car> findAll();
    List<Car> newCars();
    Car findById(Long id);
    void save(Car car);
}
