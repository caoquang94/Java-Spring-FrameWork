package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {


    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    List<Customer> findAllRest();
}
