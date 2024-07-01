package com.tiketi.service; // Définit le package du service

import com.tiketi.model.Formateur; // Importe la classe Formateur du modèle
import com.tiketi.repository.FormateurRepository; // Importe le repository FormateurRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceFormateur {

    @Autowired // Injection automatique du repository FormateurRepository
    private FormateurRepository formateurRepository;

    // Méthode pour récupérer tous les formateurs
    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll();
    }

    // Méthode pour récupérer un formateur par son ID
    public Optional<Formateur> getFormateurById(Long id) {
        return formateurRepository.findById(id);
    }

    // Méthode pour créer un nouveau formateur
    public Formateur createFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    // Méthode pour mettre à jour un formateur existant
    public Formateur updateFormateur(Long id, Formateur formateurDetails) {
        Formateur formateur = formateurRepository.findById(id).orElseThrow(); // Trouve le formateur par son ID ou lance une exception
        formateur.setUser(formateurDetails.getUser()); // Met à jour l'utilisateur associé au formateur
        return formateurRepository.save(formateur); // Sauvegarde les modifications et retourne le formateur mis à jour
    }

    // Méthode pour supprimer un formateur par son ID
    public void deleteFormateur(Long id) {
        formateurRepository.deleteById(id);
    }
}
