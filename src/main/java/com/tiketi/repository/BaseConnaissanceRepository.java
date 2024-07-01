package com.tiketi.repository;

import com.tiketi.model.BaseConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseConnaissanceRepository extends JpaRepository<BaseConnaissance, Long> {
    // Interface pour interagir avec la base de données pour les Bases de Connaissances
}
