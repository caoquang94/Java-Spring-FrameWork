package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProvinceRepository extends PagingAndSortingRepository<Province,Long> {
    @Query(value = "select e from Province e where e.name = ?1")
    Page<Province> findByName(String name, Pageable pageable);
}
