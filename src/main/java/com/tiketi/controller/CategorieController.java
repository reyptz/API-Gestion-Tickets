package com.tiketi.controller;

import com.tiketi.model.Categorie;
import com.tiketi.repository.CategorieRepository;
import com.tiketi.service.ServiceCategorie;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
@Tag(name = "Categorie", description = "Gestion des catégories")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping
    @Operation(summary = "Obtenir toutes les catégories", description = "Retourne une liste de toutes les catégories.")
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll(); // Retourner toutes les catégories
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir une catégorie par ID", description = "Retourne une catégorie spécifique par son ID.")
    public Optional<Categorie> getCategorieById(@PathVariable Long id) {
        return categorieRepository.findById(id); // Retourner une catégorie par ID
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle catégorie", description = "Crée une nouvelle catégorie.")
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie); // Créer une nouvelle catégorie
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une catégorie", description = "Met à jour les détails d'une catégorie existante.")
    public Categorie updateCategorie(@PathVariable Long id, @RequestBody Categorie categorieDetails) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow();
        categorie.setCat_name(categorieDetails.getCat_name());
        categorie.setPriority(categorieDetails.getPriority());
        return categorieRepository.save(categorie); // Mettre à jour une catégorie
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une catégorie", description = "Supprime une catégorie existante.")
    public void deleteCategorie(@PathVariable Long id) {
        categorieRepository.deleteById(id); // Supprimer une catégorie par ID
    }
}
