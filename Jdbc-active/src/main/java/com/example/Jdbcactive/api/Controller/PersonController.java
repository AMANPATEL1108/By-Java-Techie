package com.example.Jdbcactive.api.Controller;

import com.example.Jdbcactive.api.model.InputRequest;
import com.example.Jdbcactive.api.model.Person;
import com.example.Jdbcactive.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {


    @Autowired
    private PersonService service;

    @PostMapping("/savePerson")
    public String savePerson(@RequestBody InputRequest request) {
        return service.insert(request);
    }

    @GetMapping("/getPerson/{category}")
    public List<Person> getPerson(@PathVariable String category) {
        return service.getPerson(category);
    }


    @GetMapping("/getPersons")
    public List<Person> getPerson() {
        return service.getPersons();
    }

    @DeleteMapping("/deletPerson/{amount}")
    public String deletOne(@PathVariable String amount) {
        return service.delete(amount);
    }

    @DeleteMapping("/deleteAll")
    public String deletall() {
        return service.deletAll();
    }
}
