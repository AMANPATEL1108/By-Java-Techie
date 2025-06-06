package com.example.Neo4jGrapgNoSQlRelationShip.api.node;

import java.util.List;

import org.neo4j.ogm.annotation.Relationship;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private int cid;
    private String name;
    private String[] address;
    @Relationship(type = "Purchase", direction = Relationship.INCOMING)
    private List<Product> products;
}
