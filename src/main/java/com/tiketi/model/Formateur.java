package com.tiketi.model; // Définit le package du modèle

import com.fasterxml.jackson.annotation.JsonIgnore; // Importe l'annotation pour ignorer les champs lors de la sérialisation JSON
import jakarta.persistence.*; // Importe les annotations de persistance JPA
import lombok.AllArgsConstructor; // Importe l'annotation Lombok pour générer un constructeur avec tous les paramètres
import lombok.Data; // Importe l'annotation Lombok @Data pour générer des méthodes standard
import lombok.NoArgsConstructor; // Importe l'annotation Lombok pour générer un constructeur sans paramètres

import java.util.List; // Importe la classe List

@AllArgsConstructor // Génère un constructeur avec tous les paramètres
@NoArgsConstructor // Génère un constructeur sans paramètres
@Data // Génère des méthodes getter, setter, equals, hashCode et toString
@Entity // Indique que cette classe est une entité JPA
@Table(name = "formateurs") // Définit le nom de la table correspondante dans la base de données
public class Formateur {

    @Id // Indique le champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que l'ID est généré automatiquement
    private Integer id; // Identifiant unique du formateur

    @OneToOne // Relation One-to-One avec l'entité User
    @JoinColumn(name = "id_users", nullable = false) // Définit la clé étrangère et rend le champ non nullable
    //@JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private User user; // Utilisateur associé au formateur

    @OneToMany(mappedBy = "formateur") // Relation One-to-Many avec l'entité Reponse
    //@JsonIgnore // Ignore ce champ lors de la sérialisation JSON
    private List<Reponse> reponses; // Liste des réponses associées au formateur
}