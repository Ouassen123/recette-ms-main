package com.example.recette.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    public void testIngredientProperties() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setRef("ING123");
        ingredient.setNom("Farine");
        ingredient.setQuantite(200);
        ingredient.setUnite("grammes");

        assertEquals(1, ingredient.getId());
        assertEquals("ING123", ingredient.getRef());
        assertEquals("Farine", ingredient.getNom());
        assertEquals(200, ingredient.getQuantite());
        assertEquals("grammes", ingredient.getUnite());
    }


}