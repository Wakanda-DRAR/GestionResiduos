package com.example.GestionResiduos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

    @Autowired
    private NumberRepository repository;

    private int currentNumber = 0;

    public void saveNumber() {
        NumberEntity numberEntity = new NumberEntity();
        numberEntity.setNumber(currentNumber++);
        repository.save(numberEntity);
    }
}
