package com.example.Graphdatabase.api.repository;

import com.example.Graphdatabase.api.node.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface BookRepository extends Neo4jRepository<Book, String> {

	Book findByName(String name);

}
