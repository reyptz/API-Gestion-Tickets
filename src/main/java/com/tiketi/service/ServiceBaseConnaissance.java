package com.tiketi.service; // Définit le package du service

import com.tiketi.model.BaseConnaissance; // Importe la classe BaseConnaissance du modèle
import com.tiketi.repository.BaseConnaissanceRepository; // Importe le repository BaseConnaissanceRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceBaseConnaissance {

    @Autowired // Injection automatique du repository BaseConnaissanceRepository
    private BaseConnaissanceRepository baseConnaissancesRepository;

    // Méthode pour récupérer toutes les bases de connaissances
    public List<BaseConnaissance> getAllBaseConnaissances() {
        return baseConnaissancesRepository.findAll();
    }

    // Méthode pour récupérer une base de connaissances par son ID
    public Optional<BaseConnaissance> getBaseConnaissancesById(Long id) {
        return baseConnaissancesRepository.findById(id);
    }

    // Méthode pour créer une nouvelle base de connaissances
    public BaseConnaissance createBaseConnaissances(BaseConnaissance baseConnaissances) {
        return baseConnaissancesRepository.save(baseConnaissances);
    }

    // Méthode pour mettre à jour une base de connaissances existante
    public BaseConnaissance updateBaseConnaissances(Long id, BaseConnaissance baseConnaissancesDetails) {
        BaseConnaissance baseConnaissances = baseConnaissancesRepository.findById(id).orElseThrow(); // Trouve la base de connaissances par son ID ou lance une exception
        baseConnaissances.setBase_link(baseConnaissancesDetails.getBase_link()); // Met à jour le lien de la base de connaissances
        baseConnaissances.setBase_name(baseConnaissancesDetails.getBase_name()); // Met à jour le nom de la base de connaissances
        return baseConnaissancesRepository.save(baseConnaissances); // Sauvegarde les modifications et retourne la base de connaissances mise à jour
    }

    // Méthode pour supprimer une base de connaissances par son ID
    public void deleteBaseConnaissances(Long id) {
        baseConnaissancesRepository.deleteById(id);
    }
}
