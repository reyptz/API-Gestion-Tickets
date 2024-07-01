package com.tiketi.service; // Définit le package du service

import com.tiketi.model.Apprenant; // Importe la classe Apprenant du modèle
import com.tiketi.repository.ApprenantRepository; // Importe le repository ApprenantRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceApprenant {

    @Autowired // Injection automatique du repository ApprenantRepository
    private ApprenantRepository apprenantRepository;

    // Méthode pour récupérer tous les apprenants
    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }

    // Méthode pour récupérer un apprenant par son ID
    public Optional<Apprenant> getApprenantById(Long id) {
        return apprenantRepository.findById(id);
    }

    // Méthode pour créer un nouvel apprenant
    public Apprenant createApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    // Méthode pour mettre à jour un apprenant existant
    public Apprenant updateApprenant(Long id, Apprenant apprenantDetails) {
        Apprenant apprenant = apprenantRepository.findById(id).orElseThrow(); // Trouve l'apprenant par son ID ou lance une exception
        apprenant.setUser(apprenantDetails.getUser()); // Met à jour les informations de l'utilisateur associé à l'apprenant
        return apprenantRepository.save(apprenant); // Sauvegarde les modifications et retourne l'apprenant mis à jour
    }

    // Méthode pour supprimer un apprenant par son ID
    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }
}
