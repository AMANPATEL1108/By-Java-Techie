package com.example.ApacheKafka.api;

import com.example.ApacheKafka.api.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {


    @Autowired
    private KafkaTemplate<String, Object> template;

    private String topic = "javatechie";


    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        template.send("javatechie", "Hii" + name + "Welcomee to Coders World");
        return "data Publisheed";
    }

    @GetMapping("/publishJson")
    public String publishMessage() {
        User user = new User(23, "User123", new String[]{"Bangalore", "Ahmedabad", "Gandhinagar"});
        template.send("topic", user);
        return "Json data Publisheed";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
