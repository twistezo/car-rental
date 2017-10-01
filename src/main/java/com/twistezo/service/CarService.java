package com.twistezo.service;

import com.twistezo.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    List<Car> newCars();

    Car findById(Long id);

    void save(Car car);
}
