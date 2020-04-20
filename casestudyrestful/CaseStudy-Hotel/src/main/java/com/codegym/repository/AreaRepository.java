package com.codegym.repository;

import com.codegym.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {
    @Override
    @Modifying
    @Query("update Area a set a.isDelete=1 where a.id=:id")
    void deleteById(@Param("id") Long id);

    @Override
    @Query("select a from Area a where a.isDelete=0")
    List<Area> findAll();

}
