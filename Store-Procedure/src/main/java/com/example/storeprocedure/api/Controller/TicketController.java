package com.example.storeprocedure.api.Controller;

import com.example.storeprocedure.api.dao.TicketDao;
import com.example.storeprocedure.api.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketDao dao;


    @GetMapping("/findTicket")
    public List<Ticket> findTickets() {
        return dao.getTicketInfo();
    }


    @GetMapping("/findTicketCategory/{category}")
    public List<Ticket> findTicketsByCategory(@PathVariable String category) {
        return dao.getTicketInfoByCategory(category);
    }


}
