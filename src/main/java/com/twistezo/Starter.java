package com.twistezo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import javax.persistence.Persistence;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Starter implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);

        /*
        Creating for Intellij Hibernate Console working (Persistence plugin)
        */
        Persistence.createEntityManagerFactory("myPresistenceUnit");
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
    }
}
