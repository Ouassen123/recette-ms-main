package com.example.recette.controller;

import com.example.recette.bean.Recette;
import com.example.recette.dao.RecetteDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecetteWsTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RecetteDao recetteDao;

    @BeforeEach
    public void setUp() {
        Recette testRecette1 = new Recette();
        testRecette1.setRef("TestRef1");
        recetteDao.save(testRecette1);

        Recette testRecette2 = new Recette();
        testRecette2.setRef("TestRef2");
        recetteDao.save(testRecette2);
    }

    @AfterEach
    public void tearDown() {
        recetteDao.deleteAll();
    }

    @Test
    public void testFindByRef() {
        ResponseEntity<Recette> response = restTemplate.getForEntity("/api/recette/ref/{ref}", Recette.class, "TestRef1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Recette recette = response.getBody();
        assertNotNull(recette);
        assertEquals("TestRef1", recette.getRef());
    }

    @Test
    public void testDeleteByRef() {
        ResponseEntity<Integer> response = restTemplate.exchange("/api/recette/ref/{ref}",
                org.springframework.http.HttpMethod.DELETE, null, Integer.class, "TestRef1");
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNull(recetteDao.findByRef("TestRef1"));
    }



}