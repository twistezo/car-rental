package com.twistezo.service;

import com.twistezo.model.Car;
import com.twistezo.repository.CarDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void save(Car car) {
        this.carDAO.save(car);
    }

    @Override
    public List<Car> newCars() {
        return this.carDAO.newCars();
    }

    @Override
    public List<Car> findAll() {
        return this.carDAO.findAll();
    }

    @Override
    public Car findById(Long id) {
        return this.carDAO.findById(id);
    }
}
