package com.codegym.service.Impl;

import com.codegym.model.PoliceProvince;
import com.codegym.repository.PoliceProvinceRepository;
import com.codegym.service.PoliceProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PoliceProvinceServiceImpl implements PoliceProvinceService {
    @Autowired
    private PoliceProvinceRepository policeProvinceRepository;
    @Override
    public List<PoliceProvince> findAllRest() {
        return policeProvinceRepository.findAll();
    }

    @Override
    public PoliceProvince findById(Long id) {
        return policeProvinceRepository.findById(id).get();
    }

    @Override
    public void save(PoliceProvince policeProvince) {
    policeProvinceRepository.save(policeProvince);
    }

    @Override
    public void remove(Long id) {
    policeProvinceRepository.softDelete(id);
    }
}
