package com.tiketi.controller;

import com.tiketi.model.Role;
import com.tiketi.repository.RoleRepository;
import com.tiketi.service.ServiceRole;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Role", description = "Gestion des roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les roles", description = "Retourne une liste de tous les roles.")
    public List<Role> getAllRoles() {
        return roleRepository.findAll(); // Retourner tous les roles
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un role par ID", description = "Retourne un role spécifique par son ID.")
    public Optional<Role> getRoleById(@PathVariable Long id) {
        return roleRepository.findById(id); // Retourner un role par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau role", description = "Crée un nouveau role.")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role); // Créer un nouveau role
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un role", description = "Met à jour les détails d'un role existant.")
    public Role updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        Role role = roleRepository.findById(id).orElseThrow();
        role.setRole_name(roleDetails.getRole_name());
        return roleRepository.save(role); // Mettre à jour un role
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un role", description = "Supprime un role existant.")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id); // Supprimer un role par ID
    }
}
