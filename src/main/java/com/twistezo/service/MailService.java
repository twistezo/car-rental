package com.twistezo.service;

import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;

public interface MailService {

    void sendMailTest();

    void sendMail(Customer customer, BorrowedDate borrowedDate, Car car);
}
