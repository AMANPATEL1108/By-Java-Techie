package com.example.Jdbcactive.api.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputRequest {

    private int id;
    private String amount;
    private String category;

}
