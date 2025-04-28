package com.example.batch.api.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@Document(collection = "Bank Users")
public class Person {

    @Id
    private Integer id;
    private String name;
    private String email;
    private String contact_no;
    private Date dob;
    private String status;
    private double outstandingAmount;
    private Date lastDueDate;

}
