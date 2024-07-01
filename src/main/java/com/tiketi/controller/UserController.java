package com.tiketi.controller;

import com.tiketi.model.User;
import com.tiketi.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "Gestion des utilisateurs")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les utilisateurs", description = "Retourne une liste de tous les utilisateurs.")
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Retourner tous les utilisateurs
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un utilisateur par ID", description = "Retourne un utilisateur spécifique par son ID.")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id); // Retourner un utilisateur par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouvel utilisateur", description = "Crée un nouvel utilisateur.")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user); // Créer un nouvel utilisateur
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un utilisateur", description = "Met à jour les détails d'un utilisateur existant.")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setMail(userDetails.getMail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        return userRepository.save(user); // Mettre à jour un utilisateur
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un utilisateur", description = "Supprime un utilisateur existant.")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id); // Supprimer un utilisateur par ID
    }
}
