package com.twistezo.controller;

import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;
import com.twistezo.service.BorrowedDateService;
import com.twistezo.service.CarService;
import com.twistezo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author twistezo (08.03.2017)
 */

@Controller
@SessionAttributes({"customer", "borrowedDate"})
public class BookResume {

    private CarService carService;
    private BorrowedDateService borrowedDateService;
    private CustomerService customerService;

    public BookResume(CarService carService, BorrowedDateService borrowedDateService, CustomerService customerService) {
        this.carService = carService;
        this.borrowedDateService = borrowedDateService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "bookResume{car_id}", method = RequestMethod.GET)
    public String showCustomerResume(Model model,
                                    Customer customer,
                                    BorrowedDate borrowedDate,
                                    @RequestParam(value = "car_id") Long carId) {

        Car carById = carService.findById(carId);
        model.addAttribute("borrowedDate", borrowedDate);
        model.addAttribute("cust", customer);
        model.addAttribute("carById", carById);
        return "bookResume";
    }

    @RequestMapping(value = "bookResume", method = RequestMethod.POST)
    public String completeAll(Customer customer,
                                  BorrowedDate borrowedDate,
                                  SessionStatus status) {

        borrowedDateService.save(borrowedDate);
        customerService.save(customer);
        status.setComplete();
        return "redirect:/";
    }
}
