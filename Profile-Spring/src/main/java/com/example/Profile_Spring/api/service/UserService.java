package com.example.Profile_Spring.api.service;

import com.example.Profile_Spring.api.dao.UserRepo;
import com.example.Profile_Spring.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"local", "dev", "production"})
public class UserService {

    @Autowired
    private UserRepo repository;

    public List<User> findAllUsers() {
        return repository.findAll();
    }
}
