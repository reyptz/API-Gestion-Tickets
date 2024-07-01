package com.tiketi.model; // Définit le package du modèle

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiketi.enums.TypeRole; // Importe l'énumération TypeRole
import jakarta.persistence.*; // Importe les annotations de persistance JPA
import lombok.Data; // Importe l'annotation Lombok @Data pour générer des méthodes standard

import java.util.List; // Importe la classe List

@Data // Génère des méthodes getter, setter, equals, hashCode et toString
@Entity // Indique que cette classe est une entité JPA
@Table(name = "roles") // Définit le nom de la table correspondante dans la base de données
public class Role {

    @Id // Indique le champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que l'ID est généré automatiquement
    private long id; // Identifiant unique du rôle
    private TypeRole role_name; // Nom du rôle, basé sur l'énumération TypeRole

    @OneToMany(mappedBy = "role") // Relation One-to-Many avec l'entité User, gérée par le rôle
    @JsonIgnore // Gère la sérialisation JSON pour éviter les références circulaires
    private List<User> users; // Liste des utilisateurs associés au rôle
}
