package com.twistezo.service;

import com.twistezo.model.Customer;
import com.twistezo.repository.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findById(Long id) {
        return this.customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerDAO.save(customer);
    }
}
