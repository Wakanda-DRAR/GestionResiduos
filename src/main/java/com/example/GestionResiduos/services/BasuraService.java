package com.example.GestionResiduos.services;

import com.example.GestionResiduos.entity.Basura;
import com.example.GestionResiduos.repository.BasuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class BasuraService {

    @Autowired
    private BasuraRepository repository;

    private final Random random = new Random();
    private final String[] tiposBasura = {"Orgánica", "Reciclable", "Papel", "Vidrio"};

    // Método para iniciar el flujo
    public void iniciarFlujo() {
        generarBasura();
        vaciarBasura();
    }

    // Generar basura cada 5 segundos
    private void generarBasura() {
        Flux.interval(Duration.ofSeconds(5))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(tick -> {
                    Basura basura = new Basura(
                            tiposBasura[random.nextInt(tiposBasura.length)],
                            LocalDateTime.now()
                    );
                    repository.save(basura);
                    System.out.println("Basura generada: " + basura.getTipo());
                })
                .subscribe();
    }

    // Vaciar la tabla de basura cada minuto simulando la recogido de basura por parte de los servicios de limpieza
    private void vaciarBasura() {
        Flux.interval(Duration.ofMinutes(1))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(tick -> {
                    long count = repository.count();
                    System.out.println("Recogiendo basura. Total registros: " + count);
                    repository.deleteAll();
                })
                .subscribe();
    }
}

