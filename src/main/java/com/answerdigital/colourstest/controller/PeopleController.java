package com.answerdigital.colourstest.controller;

import java.util.List;
import java.util.Optional;

import com.answerdigital.colourstest.model.Colour;
import com.answerdigital.colourstest.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.answerdigital.colourstest.model.Person;

@RestController
@RequestMapping("/People")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity <List<Person>> getPeople() {
        return ResponseEntity.status(HttpStatus.OK).body(peopleService.getPeople());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
        Optional<Person> person = peopleService.getPerson(id);
        if(person.isPresent() == true)
            return ResponseEntity.status(HttpStatus.OK).body(person.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Person updatedPerson = peopleService.updatePerson(id, person);
        if(updatedPerson.equals(null)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(peopleService.getPerson(id).get());
        }
    }

    @PostMapping
    public ResponseEntity<Void> createNewPerson(@RequestBody Person person) {
        peopleService.addNewPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
