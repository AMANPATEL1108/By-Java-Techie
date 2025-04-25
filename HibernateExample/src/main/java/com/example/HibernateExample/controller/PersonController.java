package com.example.HibernateExample.controller;

import com.example.HibernateExample.dao.PersonDao;
import com.example.HibernateExample.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("springbootorm")
public class PersonController {

    @Autowired
    private PersonDao dao;

    @PostMapping("/savePerson")
    public String save(@RequestBody Person person) {
        dao.savePerson(person);
        return "Person Saved";
    }

    @GetMapping("/getAll")
    public List<Person> getAllPerson() {
        return dao.getPerson();
    }
}
