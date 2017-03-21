package com.twistezo.service;

import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;

/**
 * @author twistezo (21.03.2017)
 */
public interface MailService {

    void sendMailTest();
    void sendMail(Customer customer, BorrowedDate borrowedDate, Car car);
}
