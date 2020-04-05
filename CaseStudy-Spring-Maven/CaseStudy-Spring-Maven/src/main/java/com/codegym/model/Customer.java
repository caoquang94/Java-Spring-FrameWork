package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String number;
    private boolean isDelete;
    @OneToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
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


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String customerName = customer.getName();
        String number = customer.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");

        if (number.length() >11 || number.length() < 10){
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }
        if (!customerName.matches("^[a-zA-ZÀ-ỹ-\\s]+$")){
            errors.rejectValue("name","customerName.matches");
        }
    }
}
