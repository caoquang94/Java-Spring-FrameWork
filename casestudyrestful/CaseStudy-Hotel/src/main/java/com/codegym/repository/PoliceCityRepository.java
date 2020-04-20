package com.codegym.repository;

import com.codegym.model.Area;
import com.codegym.model.PoliceCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PoliceCityRepository extends JpaRepository<PoliceCity, Long> {
    @Query("update PoliceCity p set p.isDelete = 1 where p.id=:id")
    @Modifying
    void softDelete(Long id);

    @Override
    @Query("select p from PoliceCity p where p.isDelete=0")
    List<PoliceCity> findAll();
}
