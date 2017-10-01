package com.twistezo.controller;

import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;
import com.twistezo.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes({ "customer", "borrowedDate" })
public class BookPartTwo {

    private CarService carService;

    public BookPartTwo(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "bookPartTwo{car_id}", method = RequestMethod.GET)
    public String showSessionCar(Model model, @RequestParam(value = "car_id") Long carId) {
        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "bookPartTwo";
    }

    @RequestMapping(value = "bookPartTwo", method = RequestMethod.POST)
    public String completeCustomer(Customer customer, BorrowedDate borrowedDate, RedirectAttributes redirectAttributes,
            @RequestParam(value = "car_id") Long CarId) {
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/bookPartThree";
    }
}
