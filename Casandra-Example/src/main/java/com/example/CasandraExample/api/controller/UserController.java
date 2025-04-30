package com.example.CasandraExample.api.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.CasandraExample.api.model.User;
import com.example.CasandraExample.api.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(6437, "Aman", "Bayad", 21));
		users.add(new User(3523, "Dev", "rj", 20));
		users.add(new User(8694, "Deversh", "Demail", 19));
		users.add(new User(9854, "Dhruvil", "Bayad", 23));
		repository.saveAll(users);
	}

	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age) {
		return repository.findByAgeGreaterThan(age);
	}
}
