package com.example.GestionResiduos.controllers;

import com.example.GestionResiduos.entity.Basura;
import com.example.GestionResiduos.repository.BasuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasuraController {

    @Autowired
    private BasuraRepository repository;

    // Endpoint para listar toda la basura almacenada
    @GetMapping("/basura")
    public List<Basura> getAllBasura() {
        return repository.findAll();
    }

    // Endpoint para contar los registros en la tabla
    @GetMapping("/basura/count")
    public long countBasura() {
        return repository.count();
    }
}
