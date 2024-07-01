package com.tiketi.repository;

import com.tiketi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Interface pour interagir avec la base de données pour les tickets
}
