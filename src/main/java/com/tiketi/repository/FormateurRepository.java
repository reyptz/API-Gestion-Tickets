package com.tiketi.repository;

import com.tiketi.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    // Interface pour interagir avec la base de données pour les formateurs
}
