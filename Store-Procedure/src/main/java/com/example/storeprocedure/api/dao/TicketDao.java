package com.example.storeprocedure.api.dao;

import com.example.storeprocedure.api.model.Ticket;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao {

    @Autowired
    private EntityManager em;

    public List<Ticket> getTicketInfo(){
        return em.createStoredProcedureQuery("firstProcuder").getResultList();

    }

    public List<Ticket> getTicketInfoByCategory(String input){
        return em.createStoredProcedureQuery("secondProcedure").setParameter("tcategory",input).getResultList();

    }


}
