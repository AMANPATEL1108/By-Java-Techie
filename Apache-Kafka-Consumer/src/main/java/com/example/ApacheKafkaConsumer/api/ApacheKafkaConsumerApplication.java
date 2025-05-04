package com.example.ApacheKafkaConsumer.api;

import com.example.ApacheKafkaConsumer.api.config.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class ApacheKafkaConsumerApplication {

    List<String> messages = new ArrayList<>();
    User userFromTopic = new User();

    @GetMapping("/consumerStringMessage")
    public List<String> consumerMsg() {
        return messages;
    }

    @GetMapping("/consumeJsonMessage")
    public User consumeJsonMessage() {
        return userFromTopic;
    }

    @KafkaListener(groupId = "javatechie1", topics = "javatechie", containerFactory = "kafkaListenerContainerFactory")
    public void getMsgFromTopic(String data) {
        messages.add(data);
    }

    @KafkaListener(groupId = "javatechie2", topics = "javatechie", containerFactory = "userKafkaListenerContainerFactory")
    public void getJsonMsgFromTopic(User user) {
        userFromTopic = user;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApacheKafkaConsumerApplication.class, args);
    }
}
