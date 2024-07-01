package com.tiketi.repository;

import com.tiketi.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
    // Interface pour interagir avec la base de données pour les administrateurs
}
