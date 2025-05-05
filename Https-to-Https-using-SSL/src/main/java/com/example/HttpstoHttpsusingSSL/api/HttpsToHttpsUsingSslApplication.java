package com.example.HttpstoHttpsusingSSL.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HttpsToHttpsUsingSslApplication {

	@GetMapping("/getData")
	public String getMessage(){
		return "Accessed By Https Protocol";
	}


	public static void main(String[] args) {
		SpringApplication.run(HttpsToHttpsUsingSslApplication.class, args);
	}

}
