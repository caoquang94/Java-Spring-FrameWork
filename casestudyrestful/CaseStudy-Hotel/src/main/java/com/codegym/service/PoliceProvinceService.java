package com.codegym.service;

import com.codegym.model.PoliceProvince;

import java.util.List;

public interface PoliceProvinceService {
    List<PoliceProvince> findAllRest();

    PoliceProvince findById(Long id);

    void save(PoliceProvince policeProvince);

    void remove(Long id);
}
