package com.example.JsonDocs.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee_data")
@ToString
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String dept;
    private double salary;
}
