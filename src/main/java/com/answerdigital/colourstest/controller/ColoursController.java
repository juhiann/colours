package com.answerdigital.colourstest.controller;

import com.answerdigital.colourstest.model.Colour;
import com.answerdigital.colourstest.model.Person;
import com.answerdigital.colourstest.repository.ColoursRepository;
import java.util.List;
import java.util.Optional;

import com.answerdigital.colourstest.service.ColoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Colours")
public class ColoursController {

    @Autowired
    private ColoursService coloursService;

    @GetMapping
    public ResponseEntity<List<Colour>> getColours() {
        return new ResponseEntity(coloursService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colour> getColourById(@PathVariable("id") long id){

        Optional<Colour> colour = coloursService.getColour(id);
        if(colour.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(colour.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Void> createNewColour(@RequestBody Colour colour) {
        coloursService.addNewColour(colour);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
