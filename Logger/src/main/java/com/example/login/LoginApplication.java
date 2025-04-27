package com.example.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoginApplication {

	Logger log= LoggerFactory.getLogger(LoginApplication.class);

	@GetMapping("/test/{name}")
	public String greeting(@PathVariable  String name){
		log.debug("Request {}",name);
		String response="Hi"+name+" Welecome to Java Techiee";
		log.debug("Response {}",response);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
