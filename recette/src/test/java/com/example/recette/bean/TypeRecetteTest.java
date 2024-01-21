package com.example.recette.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeRecetteTest {

    @Test
    public void testTypeRecetteProperties() {
        TypeRecette typeRecette = new TypeRecette();
        typeRecette.setId(1);
        typeRecette.setRef("TYP123");
        typeRecette.setLibelle("Entrée");
        typeRecette.setImage("entree.jpg");

        assertEquals(1, typeRecette.getId());
        assertEquals("TYP123", typeRecette.getRef());
        assertEquals("Entrée", typeRecette.getLibelle());
        assertEquals("entree.jpg", typeRecette.getImage());
    }

}