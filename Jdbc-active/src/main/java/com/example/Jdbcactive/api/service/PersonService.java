package com.example.Jdbcactive.api.service;

import com.example.Jdbcactive.api.model.InputRequest;
import com.example.Jdbcactive.api.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonService {

    public String insert(InputRequest request) {
        Person person = new Person();
        person.set("id", request.getId());
        person.set("amount", request.getAmount());
        person.set("category", request.getCategory());
        person.insert();

        return "Recorded inserted SuccessFully";
    }

    public List<Person> getPerson(String category) {
        List<Person> person = Person.where("category=?", category);
        System.out.println(person);
        return person;
    }

    public List<Person> getPersons() {
        return Person.findAll();
    }

    public String delete(String amount) {
        int no = Person.delete("amount", amount);
        return no + " Deleted";
    }

    public String deletAll() {
        return "Deleted" + Person.deleteAll();
    }

}
