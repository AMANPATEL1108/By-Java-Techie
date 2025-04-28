package com.example.Springboot_Securit_MYSQL.repository;

import com.example.Springboot_Securit_MYSQL.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
