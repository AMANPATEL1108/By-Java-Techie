package com.example.Profile_Spring.api.controller;

import com.example.Profile_Spring.api.model.User;
import com.example.Profile_Spring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/findallusers")
    public List<User> getUsers(){
        return service.findAllUsers();

    }
}
