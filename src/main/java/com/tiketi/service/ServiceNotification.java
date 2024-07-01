package com.tiketi.service; // Définit le package du service

import com.tiketi.model.Notification; // Importe la classe Notification du modèle
import com.tiketi.repository.NotificationRepository; // Importe le repository NotificationRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceNotification {

    @Autowired // Injection automatique du repository NotificationRepository
    private NotificationRepository notificationRepository;

    // Méthode pour récupérer toutes les notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Méthode pour récupérer une notification par son ID
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    // Méthode pour créer une nouvelle notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Méthode pour mettre à jour une notification existante
    public Notification updateNotification(Long id, Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id).orElseThrow(); // Trouve la notification par son ID ou lance une exception
        notification.setContent(notificationDetails.getContent()); // Met à jour le contenu de la notification
        notification.setCreate_at(notificationDetails.getCreate_at()); // Met à jour la date de création de la notification
        notification.setUpdate_at(notificationDetails.getUpdate_at()); // Met à jour la date de mise à jour de la notification
        notification.setTicket(notificationDetails.getTicket()); // Met à jour le ticket associé à la notification
        return notificationRepository.save(notification); // Sauvegarde les modifications et retourne la notification mise à jour
    }

    // Méthode pour supprimer une notification par son ID
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
