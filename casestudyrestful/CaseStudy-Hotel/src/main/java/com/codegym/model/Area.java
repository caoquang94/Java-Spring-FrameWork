package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private short isDelete;

    @JsonIgnore
    @OneToMany(mappedBy = "area")
    private Set<PoliceProvince> policeProvinces;
    private Set<PoliceProvince> getPoliceProvinces(){return policeProvinces;}
    private void setPoliceProvinces(Set<PoliceProvince> policeProvinces){this.policeProvinces = policeProvinces;}

    @JsonIgnore
    @OneToMany(mappedBy = "area")
    private Set<PoliceCity> policeCities;
    private Set<PoliceCity> getPoliceCities(){return policeCities;}
    private void setPoliceCities(Set<PoliceCity> policeCities){this.policeCities = policeCities;}


    public Area() {
    }

    public Area(Long id, String name, short isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(short isDelete) {
        this.isDelete = isDelete;
    }
}
