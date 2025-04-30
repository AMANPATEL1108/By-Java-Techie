package com.example.relation.api.repository;

import com.example.relation.api.model.Address;
import com.example.relation.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlipkartRepository extends MongoRepository<User, String> {
    List<User> findByName(String name);


    @Query("{'address.city': ?0}")
    List<User> findByCity(String city);
}
