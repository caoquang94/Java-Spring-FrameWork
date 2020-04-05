package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Override
    @Query("select e from Customer e where e.isDelete = false")
    Iterable<Customer> findAll();

    @Query("update Customer e set e.isDelete = true where e.id=?1")
    @Modifying
    void softDelete(Long id);

    @Query(value = "select e from Customer e where e.firstName = ?1")
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
