package com.tiketi.repository;

import com.tiketi.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    // Interface pour interagir avec la base de données pour les catégories
}
