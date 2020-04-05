package com.codegym.cms.service;

import com.codegym.cms.model.Province;

public interface ProvinceService extends Service<Province> {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
