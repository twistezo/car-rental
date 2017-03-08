package com.twistezo.controller;

import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;
import com.twistezo.service.BorrowedDateService;
import com.twistezo.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

/**
 * @author twistezo (08.03.2017)
 */

@Controller
@SessionAttributes({"customer", "borrowedDate"})
public class BookPartThree {

    private CarService carService;
    private BorrowedDateService borrowedDateService;

    public BookPartThree(CarService carService, BorrowedDateService borrowedDateService) {
        this.carService = carService;
        this.borrowedDateService = borrowedDateService;
    }

    @RequestMapping(value = "bookPartThree{car_id}", method = RequestMethod.GET)
    public String showSessionCar(Model model,
                                    @RequestParam(value = "car_id") Long carId) {

        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "bookPartThree";
    }

    @RequestMapping(value = "bookPartThree", method = RequestMethod.POST)
    public String realizePayment(Customer customer,
                                    BorrowedDate borrowedDate,
                                    RedirectAttributes redirectAttributes,
                                    @RequestParam(value = "car_id") Long CarId) {

        long days = borrowedDateService.countDays(borrowedDate);
        customer.setTotalPrice(customer.getTotalPrice().multiply(new BigDecimal(days)));
        customer.setRole("ROLE_USER");
        customer.setPaid(true);
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/bookResume";
    }
}
