package com.example.recette.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String ref;
    private String description;
    private int ordre;
    private int duree;
}

