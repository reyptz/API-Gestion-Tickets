package com.tiketi.service;

import com.tiketi.model.Categorie;
import com.tiketi.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategorie {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll(); // Retourner toutes les catégories
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id); // Retourner une catégorie par ID
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie); // Créer une nouvelle catégorie
    }

    public Categorie updateCategorie(Long id, Categorie categorieDetails) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow();
        categorie.setCat_name(categorieDetails.getCat_name());
        categorie.setPriority(categorieDetails.getPriority());
        return categorieRepository.save(categorie); // Mettre à jour une catégorie existante
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id); // Supprimer une catégorie par ID
    }
}
