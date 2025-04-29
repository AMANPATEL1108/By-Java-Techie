package com.example.exception.api.dao;

import com.example.exception.api.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {
    Order findByName(String name);
}
