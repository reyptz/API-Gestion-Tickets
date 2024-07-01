package com.tiketi.service; // Définit le package du service

import com.tiketi.model.Ticket; // Importe la classe Ticket du modèle
import com.tiketi.repository.TicketRepository; // Importe le repository TicketRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@Service // Indique que cette classe est un service Spring
public class ServiceTicket {

    @Autowired // Injection automatique du repository TicketRepository
    private TicketRepository ticketRepository;

    // Méthode pour récupérer tous les tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Méthode pour récupérer un ticket par son ID
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    // Méthode pour créer un nouveau ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Méthode pour mettre à jour un ticket existant
    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(); // Trouve le ticket par son ID ou lance une exception
        ticket.setTitle(ticketDetails.getTitle()); // Met à jour le titre du ticket
        ticket.setContent(ticketDetails.getContent()); // Met à jour le contenu du ticket
        ticket.setStatus(ticketDetails.getStatus()); // Met à jour le statut du ticket
        ticket.setCreate_at(ticketDetails.getCreate_at()); // Met à jour la date de création du ticket
        ticket.setUpdate_at(ticketDetails.getUpdate_at()); // Met à jour la date de mise à jour du ticket
        ticket.setApprenant(ticketDetails.getApprenant()); // Met à jour l'apprenant associé au ticket
        ticket.setCategorie(ticketDetails.getCategorie()); // Met à jour la catégorie du ticket
        return ticketRepository.save(ticket); // Sauvegarde les modifications et retourne le ticket mis à jour
    }

    // Méthode pour supprimer un ticket par son ID
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
