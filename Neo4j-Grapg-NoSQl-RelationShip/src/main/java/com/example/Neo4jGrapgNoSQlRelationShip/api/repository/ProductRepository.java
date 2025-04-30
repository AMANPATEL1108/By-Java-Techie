package com.example.Neo4jGrapgNoSQlRelationShip.api.repository;

import com.example.Neo4jGrapgNoSQlRelationShip.api.node.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface ProductRepository extends Neo4jRepository<Product, Integer> {

}
