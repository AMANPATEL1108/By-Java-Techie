package com.example.Actuator.api.endpoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id="javatechie")
public class MyEndPoint {


    @ReadOperation
    public MyEndPointResponse deatures(){
        return new MyEndPointResponse(2356,"javatechiee","Active");
    }

}



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MyEndPointResponse{
    private int id;
    private String name;
    private String status;
}
