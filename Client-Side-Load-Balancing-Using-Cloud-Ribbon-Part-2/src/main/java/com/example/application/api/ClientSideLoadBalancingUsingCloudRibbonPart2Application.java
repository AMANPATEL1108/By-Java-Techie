package com.example.application.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "ClientSideLoadBalancingUsingCloudRibbonApplication", configuration = RibbonConfiguration.class)
public class ClientSideLoadBalancingUsingCloudRibbonPart2Application {

    @Autowired
    private RestTemplate template;

    @GetMapping("/invoke")
    public String invokeChatbook() {
        String url = "http://ClientSideLoadBalancingUsingCloudRibbonApplication/chatbook-application/chat";
        return template.getForObject(url, String.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(ClientSideLoadBalancingUsingCloudRibbonPart2Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }

}
