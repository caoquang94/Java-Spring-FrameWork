package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;

import java.util.List;

public interface ProvinceService {
    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

    List<Province> findAllRest();
}
