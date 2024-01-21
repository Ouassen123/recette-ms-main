package com.example.recette.service;


import com.example.recette.bean.Etape;
import com.example.recette.dao.EtapeDao;
import com.example.recette.service.impl.EtapeServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EtapeServiceImpTest {

    @Autowired
    private EtapeServiceImp etapeService;

    @Autowired
    private EtapeDao etapeDao;

    @BeforeEach
    public void setUp() {
        Etape testEtape = new Etape();
        testEtape.setRef("ETAPE123");
        testEtape.setDescription("Test description");
        testEtape.setOrdre(1);
        testEtape.setDuree(10);

        etapeDao.save(testEtape);
    }


    @AfterEach
    public void tearDown() {
        etapeDao.deleteAll();
    }

    @Test
    public void testDeleteByRef() {
        int result = etapeService.deleteByRef("ETAPE123");
        assertEquals(1, result);
        assertNull(etapeDao.findByRef("ETAPE123"));
    }

    @Test
    public void testSave() {
        Etape newEtape = new Etape();
        newEtape.setRef("NEWETAPE");
        newEtape.setDescription("New description");
        newEtape.setOrdre(2);
        newEtape.setDuree(15);

        int result = etapeService.save(newEtape);
        assertEquals(1, result);
        assertNotNull(etapeDao.findByRef("NEWETAPE"));
    }
    @Test
    public void testUpdate() {
        Etape existingEtape = etapeDao.findByRef("ETAPE123");
        existingEtape.setDescription("Updated description");
        existingEtape.setOrdre(2);
        existingEtape.setDuree(15);

        int result = etapeService.update(existingEtape);
        assertEquals(1, result);
        Etape updatedEtape = etapeDao.findByRef("ETAPE123");
        assertEquals("Updated description", updatedEtape.getDescription());
        assertEquals(2, updatedEtape.getOrdre());
        assertEquals(15, updatedEtape.getDuree());
    }

}