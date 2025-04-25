package com.example.api.controller;


import com.example.api.dao.TicketDao;
import com.example.api.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/ticket")
@RestController
public class TicketController {

    @Autowired
    private TicketDao dao;


    @PostMapping("/bookticket")
    public String bookTicket(@RequestBody List<Ticket> tickets){
        dao.saveAll(tickets);

        return "ticketBooked:"+tickets.size();
    }


    @GetMapping("/gettickets")
    public  List<Ticket> getTicket(){
        return (List<Ticket>) dao.findAll();
    }

}
