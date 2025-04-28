package com.example.Springboot_Securit_MYSQL.service;

import com.example.Springboot_Securit_MYSQL.model.User;
import com.example.Springboot_Securit_MYSQL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = repository.findByUsername(username);

        CustomUserDetails  userDetails=null;

        if (user != null) {
            userDetails=new CustomUserDetails();
            userDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User Not Found With this Name " + username);
        }

        return userDetails;
    }
}
