package com.codegym.service;

import com.codegym.model.PoliceCity;

import java.util.List;

public interface PoliceCityService {
    List<PoliceCity> findAllRest();

    PoliceCity findById(Long id);

    void save(PoliceCity policeCity);

    void remove(Long id);
}
