package com.tiketi.repository;

import com.tiketi.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    // Interface pour interagir avec la base de données pour les apprenants
}
