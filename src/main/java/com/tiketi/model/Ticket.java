package com.tiketi.model; // Définit le package du modèle

import com.fasterxml.jackson.annotation.JsonManagedReference; // Importe l'annotation pour gérer les références JSON
import com.tiketi.enums.TypeStatus; // Importe l'énumération TypeStatus
import jakarta.persistence.*; // Importe les annotations de persistance JPA
import lombok.Data; // Importe l'annotation Lombok @Data pour générer des méthodes standard
import java.util.Date; // Importe la classe Date
import java.util.List; // Importe la classe List

@Data // Génère des méthodes getter, setter, equals, hashCode et toString
@Entity // Indique que cette classe est une entité JPA
@Table(name = "tickets") // Définit le nom de la table correspondante dans la base de données
public class Ticket {

    @Id // Indique le champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que l'ID est généré automatiquement
    private long id; // Identifiant unique du ticket
    private String title; // Titre du ticket
    private String content; // Contenu du ticket

    @Enumerated(EnumType.STRING) // Indique que l'énumération est stockée sous forme de chaîne
    @Column(name = "status", columnDefinition = "VARCHAR(50) DEFAULT 'EN_COURS'") // Définit la colonne status avec une valeur par défaut
    private TypeStatus status; // Statut du ticket
    private Date create_at = new Date(); // Date de création du ticket, initialisée à la date actuelle
    private Date update_at; // Date de mise à jour du ticket

    @ManyToOne // Relation Many-to-One avec l'entité Apprenant
    @JoinColumn(name = "id_apprenants", nullable = false) // Définit la clé étrangère et sa non-nullité
    //@JsonManagedReference // Gère la sérialisation JSON pour éviter les références circulaires
    private Apprenant apprenant; // Apprenant associé au ticket

    @Enumerated(EnumType.STRING) // Indique que l'énumération est stockée sous forme de chaîne
    @ManyToOne // Relation Many-to-One avec l'entité Categorie
    @JoinColumn(name = "Id_categorie", nullable = false) // Définit la clé étrangère et sa non-nullité
    //@JsonManagedReference // Gère la sérialisation JSON pour éviter les références circulaires
    private Categorie categorie; // Catégorie associée au ticket

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true) // Relation One-to-Many avec l'entité Reponse, gérée par le ticket
    //@JsonManagedReference // Gère la sérialisation JSON pour éviter les références circulaires
    private List<Reponse> reponses; // Liste des réponses associées au ticket

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true) // Relation One-to-Many avec l'entité Notification, gérée par le ticket
    //@JsonManagedReference // Gère la sérialisation JSON pour éviter les références circulaires
    private List<Notification> notifications; // Liste des notifications associées au ticket

}
