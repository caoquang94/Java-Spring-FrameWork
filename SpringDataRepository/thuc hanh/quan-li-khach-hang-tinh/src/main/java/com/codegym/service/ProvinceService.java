package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService extends Service<Province> {
    Page<Province> findAll(Pageable pageable);

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

    Page<Province> findByName(String name,Pageable pageable);
}
