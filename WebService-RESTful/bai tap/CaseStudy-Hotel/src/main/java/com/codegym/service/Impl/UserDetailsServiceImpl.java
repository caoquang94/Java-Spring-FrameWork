package com.codegym.service.impl;


import com.codegym.model.User;
import com.codegym.model.UserDetailsCustom;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=  userRepository.findUserByUsername(s);
        if (user==null){
            throw  new UsernameNotFoundException("User not found");
        }
        return new UserDetailsCustom(user);

    }
}
