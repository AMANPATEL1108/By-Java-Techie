package com.example.relation.api.controller;

import com.example.relation.api.model.Address;
import com.example.relation.api.model.User;
import com.example.relation.api.repository.FlipkartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderService")
public class FlipkartOrderController {

    @Autowired
    private FlipkartRepository repository;

    @PostMapping("/placedOrderNow")
    public String placeorder(@RequestBody User user) {
        repository.save(user);
        return "Order Placed Succesfully";
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping("/getUserByAddress/{city}")
    public List<User> getUserByAddress(@PathVariable String city) {
        return repository.findByCity(city);
    }



}
