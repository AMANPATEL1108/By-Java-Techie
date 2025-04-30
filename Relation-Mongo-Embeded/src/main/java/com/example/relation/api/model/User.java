package com.example.relation.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
    @Document(collection = "order_db")
public class User {

    @Id
    private String id;
    private String name;
    private String gender;

    private List<Product> products;
    private Address address;

}
