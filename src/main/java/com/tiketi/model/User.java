package com.tiketi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*; // Importer les annotations JPA nécessaires pour les entités et les relations
import lombok.AllArgsConstructor; // Générer un constructeur avec tous les arguments
import lombok.Data; // Générer les getters, setters, equals, hashCode, toString, etc.
import lombok.NoArgsConstructor; // Générer un constructeur sans arguments

@AllArgsConstructor // Générer un constructeur avec tous les champs
@NoArgsConstructor // Générer un constructeur sans arguments
@Data // Générer les getters, setters, toString, equals et hashCode
@Entity // Indiquer que cette classe est une entité JPA
@Table(name = "users") // Spécifier le nom de la table correspondante dans la base de données
public class User {

    @Id // Indiquer que ce champ est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifier que la valeur de la clé primaire est générée automatiquement
    private long id;
    private String name;
    private String mail;
    private String password;

    @ManyToOne // Définir une relation Many-to-One avec l'entité Role
    @JoinColumn(name = "id_roles", nullable = false) // Spécifier la colonne de jointure et définir qu'elle ne peut pas être nulle

    private Role role;

    // Définir une relation One-to-One avec l'entité Formateur, Apprenant et Administrateur
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Formateur formateur;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Apprenant apprenant;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Administrateur administrateur;
}
