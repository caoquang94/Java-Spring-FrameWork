package com.codegym.repository;


import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}
