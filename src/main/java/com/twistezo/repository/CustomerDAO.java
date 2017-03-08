package com.twistezo.repository;

import com.twistezo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author twistezo (20.02.2017)
 */

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    Customer findById(Long id);
}
