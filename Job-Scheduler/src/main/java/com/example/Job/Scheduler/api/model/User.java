package com.example.Job.Scheduler.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Scheduled_Example")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;


}
