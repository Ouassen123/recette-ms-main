package com.example.recette.service;

import com.example.recette.bean.TypeRecette;
import com.example.recette.dao.TypeRecetteDao;
import com.example.recette.service.facade.TypeRecetteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TypeRecetteServiceImpTest {

    @Autowired
    private TypeRecetteService typeRecetteService;

    @Autowired
    private TypeRecetteDao typeRecetteDao;

    @BeforeEach
    public void setUp() {
        TypeRecette typeRecette1 = new TypeRecette();
        typeRecette1.setRef("REF1");
        typeRecette1.setLibelle("Libelle1");
        typeRecette1.setImage("Image1");



        typeRecetteDao.save(typeRecette1);
    }

    @AfterEach
    public void tearDown() {
        typeRecetteDao.deleteAll();
    }

    @Test
    public void testFindByRef() {
        TypeRecette foundTypeRecette = typeRecetteService.findByRef("REF1");
        assertNotNull(foundTypeRecette);
        assertEquals("REF1", foundTypeRecette.getRef());
    }

    @Test
    public void testDeleteByRef() {
        int result = typeRecetteService.deleteByRef("REF1");
        assertEquals(1, result);
        assertNull(typeRecetteDao.findByRef("REF1"));
    }

    @Test
    public void testFindAll() {
        List<TypeRecette> allTypes = typeRecetteService.findAll();
        assertEquals(1, allTypes.size());
    }

    @Test
    public void testSave() {
        TypeRecette newTypeRecette = new TypeRecette();
        newTypeRecette.setRef("NEWREF");
        newTypeRecette.setLibelle("NewLibelle");
        newTypeRecette.setImage("NewImage");

        int result = typeRecetteService.save(newTypeRecette);
        assertEquals(1, result);
        assertNotNull(typeRecetteDao.findByRef("NEWREF"));
    }

    @Test
    public void testUpdate() {
        TypeRecette existingTypeRecette = typeRecetteDao.findByRef("REF1");
        existingTypeRecette.setLibelle("UpdatedLibelle");
        existingTypeRecette.setImage("UpdatedImage");

        int result = typeRecetteService.update(existingTypeRecette);
        assertEquals(1, result);

        TypeRecette updatedTypeRecette = typeRecetteDao.findByRef("REF1");
        assertEquals("UpdatedLibelle", updatedTypeRecette.getLibelle());
        assertEquals("UpdatedImage", updatedTypeRecette.getImage());
    }
}
