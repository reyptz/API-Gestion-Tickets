package com.tiketi.controller;

import com.tiketi.model.Notification;
import com.tiketi.repository.NotificationRepository;
import com.tiketi.service.ServiceNotification;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
@Tag(name = "Notification", description = "Gestion des notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ServiceNotification notificationService;

    @GetMapping
    @Operation(summary = "Obtenir toutes les notifications", description = "Retourne une liste de toutes les notifications.")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll(); // Retourner toutes les notifications
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir une notification par ID", description = "Retourne une notification spécifique par son ID.")
    public Optional<Notification> getNotificationById(@PathVariable Long id) {
        return notificationRepository.findById(id); // Retourner une notification par ID
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle notification", description = "Crée une nouvelle notification.")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification); // Créer une nouvelle notification
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une notification", description = "Met à jour les détails d'une notification existant.")
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id).orElseThrow();
        notification.setContent(notificationDetails.getContent());
        notification.setCreate_at(notificationDetails.getCreate_at());
        notification.setUpdate_at(notificationDetails.getUpdate_at());
        notification.setTicket(notificationDetails.getTicket());
        return notificationRepository.save(notification); // Mettre à jour une notification
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une notification", description = "Supprime une notification existant.")
    public void deleteNotification(@PathVariable Long id) {
        notificationRepository.deleteById(id); // Supprimer une notification par ID
    }
}
