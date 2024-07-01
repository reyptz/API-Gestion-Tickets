package com.tiketi.controller;

import com.tiketi.model.Ticket;
import com.tiketi.repository.TicketRepository;
import com.tiketi.service.ServiceTicket;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Ticket", description = "Gestion des tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    @Operation(summary = "Obtenir tous les tickets", description = "Retourne une liste de tous les tickets.")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll(); // Retourner tous les tickets
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un ticket par ID", description = "Retourne un ticket spécifique par son ID.")
    public Optional<Ticket> getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id); // Retourner un ticket par ID
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau ticket", description = "Crée un nouveau ticket.")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket); // Créer un nouveau ticket
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un ticket", description = "Met à jour les détails d'un ticket existant.")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setTitle(ticketDetails.getTitle());
        ticket.setContent(ticketDetails.getContent());
        ticket.setStatus(ticketDetails.getStatus());
        ticket.setCreate_at(ticketDetails.getCreate_at());
        ticket.setUpdate_at(ticketDetails.getUpdate_at());
        ticket.setApprenant(ticketDetails.getApprenant());
        ticket.setCategorie(ticketDetails.getCategorie());
        return ticketRepository.save(ticket); // Mettre à jour un ticket
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un ticket", description = "Supprime un ticket existant.")
    public void deleteTicket(@PathVariable Long id) {
        ticketRepository.deleteById(id); // Supprimer un ticket par ID
    }
}
