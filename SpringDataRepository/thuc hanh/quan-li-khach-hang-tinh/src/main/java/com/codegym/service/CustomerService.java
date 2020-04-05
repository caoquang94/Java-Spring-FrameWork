package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends Service<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
