package com.OCR.ChaTopProject.model;

// Importation des classes nécessaires de la bibliothèque JPA et Lombok.
import jakarta.persistence.*;
import lombok.Data;                    // Lombok @Data génère des getters et setters automatiquement.
import lombok.NoArgsConstructor;       // @NoArgsConstructor génère un constructeur sans argument
import lombok.AllArgsConstructor;      // @AllArgsConstructor génère un constructeur avec tous les arguments.
import java.util.Date;

@Entity                                // Cette entité sera mappée à une table dans la base de données.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RENTALS")               // Spécifie le nom de la table dans la base de données

public class Rental {

    @Id                                                    // Identifiant unique de l'entité, mappé à la colonne "id" de la table.
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // @GeneratedValue indique que la valeur est générée automatiquement.
    private Long id;

    @Column(name = "name", length = 255)                   //  Champ mappé à la colonne "name" avec une longueur maximale de 255 caractères
    private String name;

    @Column(name = "surface")
    private int surface;

    @Column(name = "price")
    private int price;

    @Column(name = "picture", length = 255)
    private String picture;

    @Column(name = "description", length = 2000)
    private String description;

    @ManyToOne                               // Indique une relation plusieurs-à-un avec la table USERS. c'est le FOREIGN KEY
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false) // Définit la colonne de jointure.
    private User ownerId;                    // owner Id est un objet de User

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}

// Pas besoin d'écrire des getters et setters ou des constructeurs ici car Lombok les génère

// @Temporal a ajouter plus tard certainement