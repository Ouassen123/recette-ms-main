package com.example.recette.bean;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private String nom;
    private String description;
    private int duree;
    private Date date_publication;
    private String userRef;
    private String image;

    @OneToMany
    List<Ingredient> ingredients;
    @OneToMany
    List<Etape> etapes;

    @ManyToOne
    TypeRecette typeRecette;

}
