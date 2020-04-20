package com.codegym.service.Impl;

import com.codegym.model.Area;
import com.codegym.repository.AreaRepository;
import com.codegym.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;
    @Override
    public List<Area> findAllRest() {
        return areaRepository.findAll();
    }

    @Override
    public Area findById(Long id) {
        return areaRepository.findById(id).get();
    }

    @Override
    public void save(Area area) {
        areaRepository.save(area);
    }

    @Override
    public void remove(Long id) {
        areaRepository.deleteById(id);
    }
}
