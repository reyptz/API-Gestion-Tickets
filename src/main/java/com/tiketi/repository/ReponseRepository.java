package com.tiketi.repository;

import com.tiketi.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<Reponse, Long> {
    // Interface pour interagir avec la base de données pour les réponses
}
