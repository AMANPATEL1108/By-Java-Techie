package com.example.Neo4jGrapgNoSQlRelationShip.api.repository;

import com.example.Neo4jGrapgNoSQlRelationShip.api.node.Customer;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface CustomerRepository extends Neo4jRepository<Customer, Integer>{

	Customer findByName(String name);

}
