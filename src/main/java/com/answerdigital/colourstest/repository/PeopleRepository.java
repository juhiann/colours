package com.answerdigital.colourstest.repository;

import com.answerdigital.colourstest.dto.PersonUpdateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.answerdigital.colourstest.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE people SET id = ?1, WHERE id = ?2", nativeQuery = true)
    void updatePersonRepository(Long id,Person person);

}
