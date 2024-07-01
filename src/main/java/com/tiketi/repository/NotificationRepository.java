package com.tiketi.repository;

import com.tiketi.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Interface pour interagir avec la base de données pour les notifications
}
