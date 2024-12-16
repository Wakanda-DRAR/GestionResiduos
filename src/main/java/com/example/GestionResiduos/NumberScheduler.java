package com.example.GestionResiduos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NumberScheduler {

    @Autowired
    private NumberService numberService;

    @Scheduled(fixedRate = 5000) // Ejecuta cada 5 segundos
    public void scheduleNumberSaving() {
        numberService.saveNumber();
        System.out.println("Número guardado en la base de datos");
    }
}
