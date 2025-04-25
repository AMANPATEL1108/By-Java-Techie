package com.example.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ticket")
@Entity
@ToString
public class Ticket {


    @Id
    @GeneratedValue
    private Integer id;
    private double amount;
    private String category;



}
