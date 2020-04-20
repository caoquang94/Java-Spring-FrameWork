package com.codegym.service;

import com.codegym.model.Area;
import com.codegym.model.PoliceCity;

import java.util.List;

public interface AreaService {
    List<Area> findAllRest();

    Area findById(Long id);

    void save(Area area);

    void remove(Long id);
}
