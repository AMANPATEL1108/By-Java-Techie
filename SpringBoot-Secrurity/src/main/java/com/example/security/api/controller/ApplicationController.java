package com.example.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {


    @GetMapping("/getmsg")
    public String greeting() {
        return "spring Security Example";
    }

}
