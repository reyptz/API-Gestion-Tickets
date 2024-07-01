package com.tiketi.controller;

import com.tiketi.model.Administrateur;
import com.tiketi.repository.AdministrateurRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrateurs")
@Tag(name = "Administrateur", description = "Gestion des administrateurs")
public class AdministrateurController {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les administrateurs", description = "Retourne une liste de tous les administrateurs.")
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();  // Retourner tous les administrateurs
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un administrateur par ID", description = "Retourne un administrateur spécifique par son ID.")
    public Optional<Administrateur> getAdministrateurById(@PathVariable Long id) {
        return administrateurRepository.findById(id); // Retourner un administrateur par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouvel administrateur", description = "Crée un nouvel administrateur.")
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurRepository.save(administrateur); // Créer un nouvel administrateur
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un administrateur", description = "Met à jour les détails d'un administrateur existant.")
    public Administrateur updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur administrateurDetails) {
        Administrateur administrateur = administrateurRepository.findById(id).orElseThrow();
        administrateur.setUser(administrateurDetails.getUser());
        return administrateurRepository.save(administrateur); // Mettre à jour un administrateur
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un administrateur", description = "Supprime un administrateur existant.")
    public void deleteAdministrateur(@PathVariable Long id) {
        administrateurRepository.deleteById(id); // Supprimer un administrateur par ID
    }
}
