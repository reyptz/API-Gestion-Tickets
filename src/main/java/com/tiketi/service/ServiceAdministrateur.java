package com.tiketi.service; // Déclaration du package du service

import com.tiketi.model.Administrateur; // Importation de la classe Administrateur du modèle
import com.tiketi.repository.AdministrateurRepository; // Importation du repository pour les administrateurs
import org.springframework.beans.factory.annotation.Autowired; // Importation de l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importation de l'annotation pour indiquer que c'est un service

import java.util.List; // Importation de la classe List pour manipuler des listes
import java.util.Optional; // Importation de la classe Optional pour manipuler des valeurs potentiellement absentes

@Service // Annotation indiquant que c'est un service Spring
public class ServiceAdministrateur {

    @Autowired // Injection de dépendance automatique du repository des administrateurs
    private AdministrateurRepository administrateurRepository;

    // Méthode pour récupérer tous les administrateurs
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    // Méthode pour récupérer un administrateur par son identifiant
    public Optional<Administrateur> getAdministrateurById(Long id) {
        return administrateurRepository.findById(id);
    }

    // Méthode pour créer un nouvel administrateur
    public Administrateur createAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    // Méthode pour mettre à jour un administrateur existant
    public Administrateur updateAdministrateur(Long id, Administrateur administrateurDetails) {
        // Récupération de l'administrateur à mettre à jour par son identifiant
        Administrateur administrateur = administrateurRepository.findById(id).orElseThrow();
        // Mise à jour des détails de l'administrateur avec les nouvelles informations
        administrateur.setUser(administrateurDetails.getUser());
        // Sauvegarde de l'administrateur mis à jour dans la base de données
        return administrateurRepository.save(administrateur);
    }

    // Méthode pour supprimer un administrateur par son identifiant
    public void deleteAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }
}
