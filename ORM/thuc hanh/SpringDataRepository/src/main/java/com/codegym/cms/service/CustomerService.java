package com.codegym.cms.service;

public interface Service<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T object);

    void remove(Long id);

}
