package com.example.application.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/chatbook-application")
public class ClientSideLoadBalancingUsingCloudRibbonApplication {


    @Value("${server.port}")
    private String port;

    @GetMapping("/chat")
    public String chatNow() {
        return "apllication is up on port:" + port;
    }


    public static void main(String[] args) {
        SpringApplication.run(ClientSideLoadBalancingUsingCloudRibbonApplication.class, args);
    }

}
