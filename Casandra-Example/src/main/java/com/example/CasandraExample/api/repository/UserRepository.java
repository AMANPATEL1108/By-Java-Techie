package com.example.CasandraExample.api.repository;

import java.util.List;

import com.example.CasandraExample.api.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface UserRepository extends CassandraRepository<User, Integer> {

	@AllowFiltering
	List<User> findByAgeGreaterThan(int age);

}
