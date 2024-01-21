package com.example.recette.bean;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecetteTest {

    @Test
    public void testRecetteProperties() {
        Recette recette = new Recette();
        recette.setId(1);
        recette.setRef("REC123");
        recette.setNom("Tarte aux pommes");
        recette.setDescription("Délicieuse tarte aux pommes");
        recette.setDuree(60);
        recette.setDate_publication(new Date());
        recette.setUserRef("USER456");

        TypeRecette typeRecette = new TypeRecette();
        typeRecette.setId(1);
        typeRecette.setRef("TYP123");
        typeRecette.setLibelle("Dessert");
        typeRecette.setImage("dessert.jpg");



        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setRef("ING123");
        ingredient.setNom("Pommes");
        ingredient.setQuantite(4);
        ingredient.setUnite("unités");

        Etape etape = new Etape();
        etape.setId(1);
        etape.setRef("ETAPE123");
        etape.setDescription("Préparer la pâte");
        etape.setOrdre(1);
        etape.setDuree(30);

        recette.setTypeRecette(typeRecette);
        recette.setIngredients(Arrays.asList(ingredient));
        recette.setEtapes(Arrays.asList(etape));

        assertEquals(1, recette.getId());
        assertEquals("REC123", recette.getRef());
        assertEquals("Tarte aux pommes", recette.getNom());
        assertEquals("Délicieuse tarte aux pommes", recette.getDescription());
        assertEquals(60, recette.getDuree());
        assertNotNull(recette.getDate_publication());
        assertEquals("USER456", recette.getUserRef());

        assertNotNull(recette.getTypeRecette());
        assertEquals("Dessert", recette.getTypeRecette().getLibelle());



        assertNotNull(recette.getIngredients());
        assertEquals(1, recette.getIngredients().size());
        assertEquals("Pommes", recette.getIngredients().get(0).getNom());

        assertNotNull(recette.getEtapes());
        assertEquals(1, recette.getEtapes().size());
        assertEquals("Préparer la pâte", recette.getEtapes().get(0).getDescription());
    }


}
