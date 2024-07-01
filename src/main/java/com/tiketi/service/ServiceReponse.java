package com.tiketi.service; // Définit le package du service

import com.tiketi.model.Reponse; // Importe la classe Reponse du modèle
import com.tiketi.repository.ReponseRepository; // Importe le repository ReponseRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceReponse {

    @Autowired // Injection automatique du repository ReponseRepository
    private ReponseRepository reponseRepository;

    // Méthode pour récupérer toutes les réponses
    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }

    // Méthode pour récupérer une réponse par son ID
    public Optional<Reponse> getReponseById(Long id) {
        return reponseRepository.findById(id);
    }

    // Méthode pour créer une nouvelle réponse
    public Reponse createReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    // Méthode pour mettre à jour une réponse existante
    public Reponse updateReponse(Long id, Reponse reponseDetails) {
        Reponse reponse = reponseRepository.findById(id).orElseThrow(); // Trouve la réponse par son ID ou lance une exception
        reponse.setRes_title(reponseDetails.getRes_title()); // Met à jour le titre de la réponse
        reponse.setRes_content(reponseDetails.getRes_content()); // Met à jour le contenu de la réponse
        reponse.setRes_date(reponseDetails.getRes_date()); // Met à jour la date de la réponse
        reponse.setFormateur(reponseDetails.getFormateur()); // Met à jour le formateur de la réponse
        reponse.setTicket(reponseDetails.getTicket()); // Met à jour le ticket de la réponse
        return reponseRepository.save(reponse); // Sauvegarde les modifications et retourne la réponse mise à jour
    }

    // Méthode pour supprimer une réponse par son ID
    public void deleteReponse(Long id) {
        reponseRepository.deleteById(id);
    }
}
