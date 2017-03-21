package com.twistezo.service;

import com.google.common.collect.Lists;
import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author twistezo (21.03.2017)
 *
 * For using gmail as host:
 * -> https://www.google.com/settings/security/lesssecureapps
 * -> https://accounts.google.com/DisplayUnlockCaptcha
 */

@Service
public class MailServiceImpl implements MailService {
    private EmailService emailService;
    private CustomerService customerService;

    public MailServiceImpl(EmailService emailService, CustomerService customerService) {
        this.emailService = emailService;
        this.customerService = customerService;
    }

    @Override
    public void sendMail(Customer customer, BorrowedDate borrowedDate, Car car) {
        try {
            final Email email = DefaultEmail.builder()
                    .from(new InternetAddress("springcarrental@wp.pl"))
                    .to(Lists.newArrayList(new InternetAddress(customer.getLogin())))
                    .subject("Resume of your orders in Car Rental")
                    .body("Dear, " + customer.getFullName()
                            + "\n\nThank You for borrowing our car."
                            + "\nHere is resume of your order."
                            + "\nChosen car: " + car.getName() + ", " + car.getPrice() + " EUR/day"
                            + "\nBorrowed date range: " + borrowedDate.getStartDate() + " - " + borrowedDate.getEndDate()
                            + "\nTotal price: " + customer.getTotalPrice() + " EUR")
                    .encoding("UTF-8").build();
            emailService.send(email);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sendMailTest() {
        try {
            final Email email = DefaultEmail.builder()
                    .from(new InternetAddress("springcarrental@wp.pl"))
                    .to(Lists.newArrayList(new InternetAddress("twistezo@outlook.com")))
                    .subject("Resume of your orders in Car Rental")
                    .body("Dear, ")
                    .encoding("UTF-8").build();
            emailService.send(email);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
        }

    }
}

