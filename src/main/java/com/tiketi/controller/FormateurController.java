package com.tiketi.controller;

import com.tiketi.model.Formateur;
import com.tiketi.repository.FormateurRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formateurs")
@Tag(name = "Formateur", description = "Gestion des formateurs")
public class FormateurController {

    @Autowired
    private FormateurRepository formateurRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les formateurs", description = "Retourne une liste de tous les formateurs.")
    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll(); // Retourner tous les formateurs
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un formateur par ID", description = "Retourne un formateur spécifique par son ID.")
    public Optional<Formateur> getFormateurById(@PathVariable Long id) {
        return formateurRepository.findById(id); // Retourner un formateur par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau formateur", description = "Crée un nouveau formateur.")
    public Formateur createFormateur(@RequestBody Formateur formateur) {
        return formateurRepository.save(formateur); // Créer un nouveau formateur
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un formateur", description = "Met à jour les détails d'un formateur existant.")
    public Formateur updateFormateur(@PathVariable Long id, @RequestBody Formateur formateurDetails) {
        Formateur formateur = formateurRepository.findById(id).orElseThrow();
        formateur.setUser(formateurDetails.getUser());
        return formateurRepository.save(formateur); // Mettre à jour un formateur
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un formateur", description = "Supprime un formateur existant.")
    public void deleteFormateur(@PathVariable Long id) {
        formateurRepository.deleteById(id); // Supprimer un formateur par ID
    }
}
