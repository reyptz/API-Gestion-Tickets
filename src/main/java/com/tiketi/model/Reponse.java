package com.tiketi.model; // Définit le package du modèle

import com.fasterxml.jackson.annotation.JsonIgnore; // Importe l'annotation pour ignorer les champs lors de la sérialisation JSON
import jakarta.persistence.*; // Importe les annotations de persistance JPA
import lombok.Data; // Importe l'annotation Lombok @Data pour générer des méthodes standard

import java.util.Date; // Importe la classe Date

@Data // Génère des méthodes getter, setter, equals, hashCode et toString
@Entity // Indique que cette classe est une entité JPA
@Table(name = "reponses") // Définit le nom de la table correspondante dans la base de données
public class Reponse {

    @Id // Indique le champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que l'ID est généré automatiquement
    private long id; // Identifiant unique de la réponse
    private String res_title; // Titre de la réponse
    private String res_content; // Contenu de la réponse
    private Date res_date; // Date de la réponse

    @ManyToOne // Relation Many-to-One avec l'entité Formateur
    @JoinColumn(name = "id_formateurs", nullable = false) // Définit la clé étrangère et rend le champ non nullable
    //@JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private Formateur formateur; // Formateur associé à la réponse

    @ManyToOne // Relation Many-to-One avec l'entité Ticket
    @JoinColumn(name = "Id_tickets", nullable = false) // Définit la clé étrangère et rend le champ non nullable
    //@JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private Ticket ticket; // Ticket associé à la réponse
}
