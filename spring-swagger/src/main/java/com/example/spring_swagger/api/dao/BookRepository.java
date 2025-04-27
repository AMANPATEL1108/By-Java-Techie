package com.example.spring_swagger.api.dao;

import com.example.spring_swagger.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
