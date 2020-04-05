package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "users")
@Component
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name Not Empty")
    @Size(min = 5, max = 45)
    private String firstname;

    @NotEmpty(message = "Name Not Empty")
    @Size(min = 5, max = 45)
    private String lastname;


    private String phonenumber;

    @Min(18)
    @NotNull
    private Long age;

    @Email
    @NotEmpty
    private String email;

//    @Override
//    public String toString(){
//        return String.format("User[id=%d, firstname='%s', lastname='%s', phonenumber='%s', age='%s', email ='%s']",id, firstname, lastname, phonenumber, age,email);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phonenumber = user.getPhonenumber();
        ValidationUtils.rejectIfEmpty(errors, "phonenumber", "phonenumber.empty");
        if (phonenumber.length()>11 || phonenumber.length()<10){
            errors.rejectValue("phonenumber", "phonenumber.length");
        }
        if(!phonenumber.startsWith("0")){
            errors.rejectValue("phonenumber", "phonenumber.startsWith");
        }
        if (!phonenumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phonenumber", "phonenumber.matches");
        }
    }
}
