package com.twistezo;

import com.twistezo.service.MailService;
import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import javax.persistence.Persistence;


/**
 * @author twistezo (20.02.2017)
 */

@EnableEmailTools
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Starter implements ApplicationRunner {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);

        /*
        Creating for Intellij Hibernate Console working (Persistence plugin)
        */
        Persistence.createEntityManagerFactory("myPresistenceUnit");
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        mailService.sendMailTest();
    }
}
