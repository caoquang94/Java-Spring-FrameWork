package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    @Override
    @Query("select e from Customer e where e.isDelete = false")
    Iterable<Customer> findAll();

    @Query("update Customer e set e.isDelete = true where e.id=?1")
    @Modifying
    void softDelete(Long id);
}
