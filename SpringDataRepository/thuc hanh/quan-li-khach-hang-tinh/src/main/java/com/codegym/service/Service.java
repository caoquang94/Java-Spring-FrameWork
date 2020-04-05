package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T> {
        Page<T> findAll(Pageable pageable);

        T findById(Long id);

        void save(T object);

        void remove(Long id);

}
