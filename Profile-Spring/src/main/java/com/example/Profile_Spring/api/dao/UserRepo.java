package com.example.Profile_Spring.api.dao;

import com.example.Profile_Spring.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
