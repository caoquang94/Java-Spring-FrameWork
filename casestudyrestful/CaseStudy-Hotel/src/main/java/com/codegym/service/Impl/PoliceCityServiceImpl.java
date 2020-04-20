package com.codegym.service.Impl;

import com.codegym.model.PoliceCity;
import com.codegym.repository.PoliceCityRepository;
import com.codegym.service.PoliceCityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PoliceCityServiceImpl implements PoliceCityService {
    @Autowired
    private PoliceCityRepository policeCityRepository;
    @Override
    public List<PoliceCity> findAllRest() {
        return policeCityRepository.findAll();
    }

    @Override
    public PoliceCity findById(Long id) {
        return policeCityRepository.findById(id).get();
    }

    @Override
    public void save(PoliceCity policeCity) {
        policeCityRepository.save(policeCity);
    }

    @Override
    public void remove(Long id) {
        policeCityRepository.softDelete(id);
    }
}
