package com.tiketi.service; // Définit le package du service

import com.tiketi.model.Role; // Importe la classe Role du modèle
import com.tiketi.repository.RoleRepository; // Importe le repository RoleRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceRole {

    @Autowired // Injection automatique du repository RoleRepository
    private RoleRepository roleRepository;

    // Méthode pour récupérer tous les rôles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Méthode pour récupérer un rôle par son ID
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    // Méthode pour créer un nouveau rôle
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    // Méthode pour mettre à jour un rôle existant
    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id).orElseThrow(); // Trouve le rôle par son ID ou lance une exception
        role.setRole_name(roleDetails.getRole_name()); // Met à jour le nom du rôle
        return roleRepository.save(role); // Sauvegarde les modifications et retourne le rôle mis à jour
    }

    // Méthode pour supprimer un rôle par son ID
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
