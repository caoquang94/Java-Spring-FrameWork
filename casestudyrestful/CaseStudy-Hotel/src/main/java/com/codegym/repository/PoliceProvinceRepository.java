package com.codegym.repository;

import com.codegym.model.Area;
import com.codegym.model.PoliceProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PoliceProvinceRepository extends JpaRepository<PoliceProvince, Long> {

    @Query("update PoliceProvince p set p.isDelete = 1 where p.id=:id")
    @Modifying
    void softDelete(Long id);

    @Override
    @Query("select p from PoliceProvince p where p.isDelete=0")
    List<PoliceProvince> findAll();
}
