package com.answerdigital.colourstest.service;

import com.answerdigital.colourstest.model.Colour;
import com.answerdigital.colourstest.model.Person;
import com.answerdigital.colourstest.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> getPeople() {
        List<Person> peopleList = peopleRepository.findAll();
        return peopleList;
    }

    public Optional<Person> getPerson(long id) {
        return peopleRepository.findById(id);
    }

    public Person updatePerson(Long id, Person person) {
        if(isPersonExist(id)){
            person.setId(id);
            return peopleRepository.save(person);
        } else {
            return null;
        }
    }

    public boolean isPersonExist(Long id){
        return getPerson(id).isPresent() ? true : false;
    }

    public void addNewPerson(Person person) {
        peopleRepository.save(person);
    }


}
