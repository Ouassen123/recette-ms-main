package com.example.recette.service;

import com.example.recette.bean.Ingredient;
import com.example.recette.dao.IngredientDao;
import com.example.recette.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class IngredientServiceImpTest {

    @Autowired
    private IngredientServiceImpl ingredientService;

    @Autowired
    private IngredientDao ingredientDao;

    @BeforeEach
    public void setUp() {
        Ingredient testIngredient = new Ingredient();
        testIngredient.setRef("ING123");
        testIngredient.setNom("Test Ingredient");
        testIngredient.setQuantite(5);
        testIngredient.setUnite("grams");

        ingredientDao.save(testIngredient);
    }

    @AfterEach
    public void tearDown() {
        ingredientDao.deleteAll();
    }
    @Test
    public void testDeleteByRef() {
        int result = ingredientService.deleteByRef("ING123");
        assertEquals(1, result);
        assertNull(ingredientDao.findByRef("ING123"));

    }

    @Test
    public void testSave() {
        Ingredient newIngredient = new Ingredient();
        newIngredient.setRef("NEWING");
        newIngredient.setNom("New Ingredient");
        newIngredient.setQuantite(10);
        newIngredient.setUnite("pieces");

        int result = ingredientService.save(newIngredient);
        assertEquals(1, result);
        assertNotNull(ingredientDao.findByRef("NEWING"));
    }

    @Test
    public void testUpdate() {
        Ingredient existingIngredient = ingredientDao.findByRef("ING123");
        existingIngredient.setNom("Updated Ingredient");
        existingIngredient.setQuantite(10);
        existingIngredient.setUnite("pieces");

        int result = ingredientService.update(existingIngredient);
        assertEquals(1, result);
        Ingredient updatedIngredient = ingredientDao.findByRef("ING123");
        assertEquals("Updated Ingredient", updatedIngredient.getNom());
        assertEquals(10, updatedIngredient.getQuantite());
        assertEquals("pieces", updatedIngredient.getUnite());
    }
}