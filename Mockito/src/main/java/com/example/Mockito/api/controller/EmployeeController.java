package com.example.Mockito.api.controller;

import com.example.Mockito.api.dao.EmployeeREpository;
import com.example.Mockito.api.model.Employee;
import com.example.Mockito.api.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {


    @Autowired
    private EmployeeREpository repository;

    @PostMapping("/addemp")
    public Response addEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return new Response(employee.getId() + "Inserted", Boolean.TRUE);
    }

    @GetMapping("/getemp")
    public Response getAllEmpolyee() {
        List<Employee> employees = repository.findAll();
        return new Response("Record Count:" + employees.size(), Boolean.TRUE);
    }
}
