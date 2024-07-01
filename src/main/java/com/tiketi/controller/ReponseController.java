package com.tiketi.controller;

import com.tiketi.model.Reponse;
import com.tiketi.repository.ReponseRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reponses")
@Tag(name = "Reponse", description = "Gestion des reponses")
public class ReponseController {

    @Autowired
    private ReponseRepository reponseRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les reponses", description = "Retourne une liste de tous les reponses.")
    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll(); // Retourner tous les reponses
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un reponse par ID", description = "Retourne un reponse spécifique par son ID.")
    public Optional<Reponse> getReponseById(@PathVariable Long id) {
        return reponseRepository.findById(id); // Retourner un reponse par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau reponse", description = "Crée un nouveau reponse.")
    public Reponse createReponse(@RequestBody Reponse reponse) {
        return reponseRepository.save(reponse); // Créer un nouveau reponse
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un reponse", description = "Met à jour les détails d'un reponse existant.")
    public Reponse updateReponse(@PathVariable Long id, @RequestBody Reponse reponseDetails) {
        Reponse reponse = reponseRepository.findById(id).orElseThrow();
        reponse.setRes_title(reponseDetails.getRes_title());
        reponse.setRes_content(reponseDetails.getRes_content());
        reponse.setRes_date(reponseDetails.getRes_date());
        reponse.setFormateur(reponseDetails.getFormateur());
        reponse.setTicket(reponseDetails.getTicket());
        return reponseRepository.save(reponse); // Mettre à jour un reponse
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un reponse", description = "Supprime un reponse existant.")
    public void deleteReponse(@PathVariable Long id) {
        reponseRepository.deleteById(id); // Supprimer un reponse par ID
    }
}
