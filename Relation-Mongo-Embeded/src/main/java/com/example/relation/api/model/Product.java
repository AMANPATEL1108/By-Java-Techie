package com.example.relation.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private  String name;
    private int quantity;
    private int price;

}
