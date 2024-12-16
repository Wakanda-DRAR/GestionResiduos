package com.example.GestionResiduos.repository;

import com.example.GestionResiduos.entity.Basura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasuraRepository extends JpaRepository<Basura, Long> {
    void deleteAll();
}
