package com.example.recette.service;


import com.example.recette.bean.*;
import com.example.recette.dao.RecetteDao;

import com.example.recette.service.facade.TypeRecetteService;
import com.example.recette.service.impl.RecetteServiceImpl;
import com.example.recette.vo.ResponseEntity;
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
public class RecetteServiceImpTest {

    @Autowired
    private RecetteDao recetteDao;

    @Autowired
    private TypeRecetteService typeRecetteService;

    @Autowired
    private RecetteServiceImpl recetteService;
    @BeforeEach
    public void setUp() {
        Recette recette1 = new Recette();
        recette1.setRef("REF123");
        recetteDao.save(recette1);

        Recette recette2 = new Recette();
        recette1.setRef("REF213");
        recetteDao.save(recette2);
    }

    @AfterEach
    public void tearDown() {
        recetteDao.deleteAll();
    }

    @Test
    public void testFindByRef() {
        Recette recette = new Recette();
        recette.setRef("REC123");
        recetteDao.save(recette);

        Recette foundRecette = recetteService.findByRef("REC123");
        assertNotNull(foundRecette);
        assertEquals("REC123", foundRecette.getRef());
    }

    @Test
    public void testFindByUserRef() {
        Recette recette1 = new Recette();
        recette1.setUserRef("USER123");
        recetteDao.save(recette1);

        Recette recette2 = new Recette();
        recette2.setUserRef("USER123");
        recetteDao.save(recette2);

        List<ResponseEntity> recettes = recetteService.findByUserRef("USER123");
        assertNotNull(recettes);
        assertEquals(2, recettes.size());
    }

    @Test
    public void testDeleteByRef() {
        Recette recette = new Recette();
        recette.setRef("REC123");
        recetteDao.save(recette);

        int result = recetteService.deleteByRef("REC123");
        assertEquals(1, result);
        assertNull(recetteDao.findByRef("REC123"));
    }



    @Test
    public void testFindAllByTypeRecetteRef() {
        TypeRecette typeRecette = new TypeRecette();
        typeRecette.setRef("TYPE123");
        typeRecetteService.save(typeRecette);

        Recette recette1 = new Recette();
        recette1.setTypeRecette(typeRecette);
        recetteDao.save(recette1);

        Recette recette2 = new Recette();
        recette2.setTypeRecette(typeRecette);
        recetteDao.save(recette2);

        List<Recette> recettes = recetteService.findAllByTypeRecetteRef("TYPE123");
        assertNotNull(recettes);
        assertEquals(2, recettes.size());
    }
}
