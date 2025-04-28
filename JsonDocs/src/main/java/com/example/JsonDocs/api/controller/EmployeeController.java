package com.example.JsonDocs.api.controller;

import com.example.JsonDocs.api.model.Employee;
import com.example.JsonDocs.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    public String save(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @RequestMapping(value = "/getemp/{id}", method = RequestMethod.GET)
    public Optional<Employee> getemp(@PathVariable Integer id) {
        return service.getEmployee(id);
    }

    @RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.DELETE)
    public List<Employee> deleteEmp(@PathVariable Integer id) {
        return service.deleteEmployee(id);
    }

}
