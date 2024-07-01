package com.tiketi.model; // Définit le package du modèle

import com.fasterxml.jackson.annotation.JsonIgnore; // Importe l'annotation pour ignorer les champs lors de la sérialisation JSON
import jakarta.persistence.*; // Importe les annotations de persistance JPA
import lombok.Data; // Importe l'annotation Lombok @Data pour générer des méthodes standard

@Data // Génère des méthodes getter, setter, equals, hashCode et toString
@Entity // Indique que cette classe est une entité JPA
@Table(name = "base_connaissances") // Définit le nom de la table correspondante dans la base de données
public class BaseConnaissance {

    @Id // Indique le champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que l'ID est généré automatiquement
    private long id; // Identifiant unique de la base de connaissances

    private String base_link; // Lien vers la base de connaissances
    private String base_name; // Nom de la base de connaissances

    @ManyToOne // Relation Many-to-One avec l'entité Categorie
    @JoinColumn(name = "Id_categorie", nullable = false) // Définit la clé étrangère et rend le champ non nullable
    @JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private Categorie categorie; // Catégorie associée à la base de connaissances
}
