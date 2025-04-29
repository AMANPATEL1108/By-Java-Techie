package com.example.Mockito.api.dao;

import com.example.Mockito.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeREpository extends JpaRepository<Employee, Integer> {
}
