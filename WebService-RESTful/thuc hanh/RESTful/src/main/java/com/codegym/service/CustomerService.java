package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {


    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    List<Customer> findAllRest();
}
