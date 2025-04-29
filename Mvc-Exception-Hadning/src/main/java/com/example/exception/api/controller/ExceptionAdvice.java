package com.example.exception.api.controller;

import com.example.exception.api.Exception.OrderServiceException;
import com.example.exception.api.Model.Order;
import com.example.exception.api.Model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
public class ExceptionAdvice {

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<OrderError> mapException(OrderServiceException ex){

        OrderError error=new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());


        return new ResponseEntity<OrderError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
