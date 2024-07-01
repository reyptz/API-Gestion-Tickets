package com.tiketi.model; // Définit le package du modèle

import com.fasterxml.jackson.annotation.JsonIgnore; // Importe l'annotation pour ignorer les champs lors de la sérialisation JSON
import jakarta.persistence.*; // Importe les annotations de persistance JPA
import lombok.AllArgsConstructor; // Importe l'annotation pour générer un constructeur avec tous les paramètres
import lombok.Data; // Importe l'annotation Lombok @Data pour générer des méthodes standard
import lombok.NoArgsConstructor; // Importe l'annotation pour générer un constructeur sans paramètres

import java.util.List; // Importe la classe List

@AllArgsConstructor // Génère un constructeur avec tous les paramètres
@NoArgsConstructor // Génère un constructeur sans paramètres
@Data // Génère des méthodes getter, setter, equals, hashCode et toString
@Entity // Indique que cette classe est une entité JPA
@Table(name = "apprenants") // Définit le nom de la table correspondante dans la base de données
public class Apprenant {

    @Id // Indique le champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que l'ID est généré automatiquement
    private Integer id; // Identifiant unique de l'apprenant

    @OneToOne // Relation One-to-One avec l'entité User
    @JoinColumn(name = "id_users", nullable = false) // Définit la clé étrangère et rend le champ non nullable
    @JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private User user; // Utilisateur associé à l'apprenant

    @OneToMany(mappedBy = "apprenant") // Relation One-to-Many avec l'entité Ticket
    @JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private List<Ticket> tickets; // Liste de tickets associés à l'apprenant
}
