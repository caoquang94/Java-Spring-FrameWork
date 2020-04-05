package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public void save(Province object) {
        provinceRepository.save(object);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Page<Province> findByName(String name, Pageable pageable) {
        return provinceRepository.findByName(name, pageable);
    }


}
