package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "PoliceCitys")
public class PoliceCity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String tel;
    private short isDelete;

    @ManyToOne
    @JoinColumn
    private Area area;
    public PoliceCity(Area area){this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public PoliceCity(){
    }

    public PoliceCity(Long id, String name, String address, String tel, short isDelete) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(short isDelete) {
        this.isDelete = isDelete;
    }
}
