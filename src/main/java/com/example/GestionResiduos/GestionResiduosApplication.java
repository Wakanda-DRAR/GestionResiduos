package com.example.GestionResiduos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionResiduosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionResiduosApplication.class, args);
    }
}