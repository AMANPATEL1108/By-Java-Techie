package com.example.exception.api.controller;

import com.example.exception.api.Exception.OrderServiceException;
import com.example.exception.api.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderContoller {
    @Autowired
    private OrderService service;

    @GetMapping("/getPricce/{productName}")
    public String getOrderPrice(@PathVariable String productName) throws OrderServiceException {
        double amount = service.getPrice(productName);
        return "amount for Product" + productName + "is" + amount;
    }


}
