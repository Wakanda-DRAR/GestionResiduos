package com.example.GestionResiduos;

import com.example.GestionResiduos.services.BasuraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GestionResiduosApplication {

    @Autowired
    private BasuraService basuraService;

    public static void main(String[] args) {
        SpringApplication.run(GestionResiduosApplication.class, args);
    }

    @PostConstruct
    public void iniciarFlujo() {
        // Inicia el flujo de generación y recolección de basura
        basuraService.iniciarFlujo();
    }
}
