package com.tiketi.controller;

import com.tiketi.model.Apprenant;
import com.tiketi.repository.ApprenantRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apprenants")
@Tag(name = "Apprenant", description = "Gestion des apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantRepository apprenantRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les apprenants", description = "Retourne une liste de tous les apprenants.")
    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();  // Retourner tous les apprenants
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un apprenant par ID", description = "Retourne un apprenant spécifique par son ID.")
    public Optional<Apprenant> getApprenantById(@PathVariable Long id) {
        return apprenantRepository.findById(id); // Retourner un apprenant par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouvel apprenant", description = "Crée un nouvel apprenant.")
    public Apprenant createApprenant(@RequestBody Apprenant apprenant) {
        return apprenantRepository.save(apprenant); // Créer un nouvel apprenant
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un apprenant", description = "Met à jour les détails d'un apprenant existant.")
    public Apprenant updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails) {
        Apprenant apprenant = apprenantRepository.findById(id).orElseThrow();
        apprenant.setUser(apprenantDetails.getUser());
        return apprenantRepository.save(apprenant); // Mettre à jour un apprenant
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un apprenant", description = "Supprime un apprenant existant.")
    public void deleteApprenant(@PathVariable Long id) {
        apprenantRepository.deleteById(id); // Supprimer un apprenant par ID
    }
}
