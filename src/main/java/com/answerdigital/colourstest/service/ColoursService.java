package com.answerdigital.colourstest.service;

import com.answerdigital.colourstest.model.Colour;
import com.answerdigital.colourstest.repository.ColoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ColoursService {

    private ColoursRepository coloursRepository;

    @Autowired
    public ColoursService(ColoursRepository coloursRepository) {
        this.coloursRepository = coloursRepository;
    }

    public List<Colour> findAll() {
      return coloursRepository.findAll();
    }

    public Optional<Colour> getColour(long id) {
        return coloursRepository.findById(id);
    }

    public void addNewColour(Colour colour) {
        coloursRepository.save(colour);
    }
}
