package com.twistezo.service;

import com.twistezo.model.Customer;

import java.util.List;

/**
 * @author twistezo (20.02.2017)
 */
public interface CustomerService {

    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
}
