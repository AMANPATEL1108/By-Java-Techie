package com.example.storeprocedure.api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "firstProcuder", procedureName = "getTickets"), @NamedStoredProcedureQuery(name = "secondProcedure", procedureName = "getTicketBycategory", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN
        , name = "tcategory", type = String.class
)})})
public class Ticket {

    @Id
    private int id;
    private String amount;
    private String category;


}
