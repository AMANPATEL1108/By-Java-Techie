package com.example.exception.api.Service;

import com.example.exception.api.Exception.OrderServiceException;
import com.example.exception.api.Model.Order;
import com.example.exception.api.dao.OrderDao;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    @PostConstruct
    public void addOrder2DB() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(45, "Moto", "Elecctrical", 8000));
        orders.add(new Order(65, "Bike", "vehical", 70000));
        dao.saveAll(orders);
    }


    public double getPrice(String productName) throws OrderServiceException {
        Order order = null;
        double  amount=0;
        try {
            order = dao.findByName(productName);
            amount= order.getAmount();

        } catch (Exception e) {

            throw  new OrderServiceException("Order Not Found With Products:"+productName);

        }
        return amount;

    }

}
