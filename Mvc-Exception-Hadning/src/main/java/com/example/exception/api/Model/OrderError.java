package com.example.exception.api.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OrderError {
    private Integer errorCode;
    private String errorMessage;
}
