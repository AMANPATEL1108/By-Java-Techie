package com.example.Job.Scheduler.api.dao;

import com.example.Job.Scheduler.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
