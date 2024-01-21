package com.example.recette.bean;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private String nom;
    private int quantite;
    private String unite;
}