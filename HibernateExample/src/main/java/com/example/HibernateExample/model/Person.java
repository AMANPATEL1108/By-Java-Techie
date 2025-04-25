package com.example.HibernateExample.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.apache.juli.JsonFormatter;

import java.util.Date;


@Entity
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dob;



}
