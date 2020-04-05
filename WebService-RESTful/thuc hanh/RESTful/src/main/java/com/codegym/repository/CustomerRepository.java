package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
