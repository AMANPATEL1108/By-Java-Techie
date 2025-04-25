package com.example.api.dao;

import com.example.api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository<Ticket,Integer> {
}
