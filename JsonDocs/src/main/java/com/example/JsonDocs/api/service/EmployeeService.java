package com.example.JsonDocs.api.service;


import com.example.JsonDocs.api.dao.EmployeeRepository;
import com.example.JsonDocs.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public String saveEmployee(Employee employee) {
        repository.save(employee);
        return "Your Data Saved" + employee.getId();
    }

    public Optional<Employee> getEmployee(Integer id){
        return repository.findById(id);
    }


    public List<Employee> deleteEmployee(Integer id){
        repository.deleteById(id);
        return repository.findAll();
    }
}
