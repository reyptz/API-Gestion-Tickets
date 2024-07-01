package com.tiketi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tiketi.enums.TypeCategorie; // Importer l'énumération TypeCategorie
import com.tiketi.enums.TypePriority; // Importer l'énumération TypePriority
import jakarta.persistence.*; // Importer les annotations JPA nécessaires pour les entités et les relations
import lombok.AllArgsConstructor; // Générer un constructeur avec tous les arguments
import lombok.Data; // Générer les getters, setters, equals, hashCode, toString, etc.
import lombok.NoArgsConstructor; // Générer un constructeur sans arguments
import java.util.List; // Importer la classe List pour gérer les collections

@AllArgsConstructor // Générer un constructeur avec tous les champs
@NoArgsConstructor // Générer un constructeur sans arguments
@Data // Générer les getters, setters, toString, equals et hashCode
@Entity // Indiquer que cette classe est une entité JPA
@Table(name = "categorie") // Spécifier le nom de la table correspondante dans la base de données
public class Categorie {

    @Id // Indiquer que ce champ est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifier que la valeur de la clé primaire est générée automatiquement
    private long id;
    private TypeCategorie cat_name; // Nom de la catégorie de type énuméré
    private TypePriority priority; // Priorité de la catégorie de type énuméré

    @OneToMany(mappedBy = "categorie") // Définir une relation One-to-Many avec l'entité BaseConnaissance
    @JsonIgnore
    private List<BaseConnaissance> baseConnaissance; // Liste des connaissances de base associées à cette catégorie
}
