package com.tiketi.controller;

import com.tiketi.model.BaseConnaissance;
import com.tiketi.repository.BaseConnaissanceRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/base-connaissances")
@Tag(name = "Base de Connaissance", description = "Gestion des bases de connaissances")
public class BaseConnaissanceController {

    @Autowired
    private BaseConnaissanceRepository baseConnaissancesRepository;

    @GetMapping
    @Operation(summary = "Obtenir toutes les bases de connaissances", description = "Retourne une liste de toutes les bases de connaissances.")
    public List<BaseConnaissance> getAllBaseConnaissances() {
        return baseConnaissancesRepository.findAll(); // Retourner toutes les bases de connaissances
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir une base de connaissance par ID", description = "Retourne une base de connaissance spécifique par son ID.")
    public Optional<BaseConnaissance> getBaseConnaissancesById(@PathVariable Long id) {
        return baseConnaissancesRepository.findById(id); // Retourner une base de connaissance par ID
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle base de connaissance", description = "Crée une nouvelle base de connaissance.")
    public BaseConnaissance createBaseConnaissances(@RequestBody BaseConnaissance baseConnaissances) {
        return baseConnaissancesRepository.save(baseConnaissances); // Créer une nouvelle base de connaissance
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une base de connaissance", description = "Met à jour les détails d'une base de connaissance existant.")
    public BaseConnaissance updateBaseConnaissances(@PathVariable Long id, @RequestBody BaseConnaissance baseConnaissancesDetails) {
        BaseConnaissance baseConnaissances = baseConnaissancesRepository.findById(id).orElseThrow();
        baseConnaissances.setBase_link(baseConnaissancesDetails.getBase_link());
        baseConnaissances.setBase_name(baseConnaissancesDetails.getBase_name());
        return baseConnaissancesRepository.save(baseConnaissances); // Mettre à jour une base de connaissance
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une base de connaissance", description = "Supprime une base de connaissance existant.")
    public void deleteBaseConnaissances(@PathVariable Long id) {
        baseConnaissancesRepository.deleteById(id); // Supprimer une base de connaissance par ID
    }
}
