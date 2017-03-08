package com.twistezo;

import com.twistezo.model.BorrowedDate;
import com.twistezo.model.Car;
import com.twistezo.model.Customer;
import com.twistezo.service.BorrowedDateService;
import com.twistezo.service.CarService;
import com.twistezo.service.CustomerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;


/**
 * @author twistezo (20.02.2017)
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);

        /*
        Creating for Intellij Hibernate Console working (Persistence plugin)
        */
        Persistence.createEntityManagerFactory("myPresistenceUnit");
    }

}
