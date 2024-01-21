package com.example.recette.controller;

import com.example.recette.bean.TypeRecette;
import com.example.recette.dao.TypeRecetteDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TypeRecetteWsTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TypeRecetteDao typeRecetteDao;

    @BeforeEach
    public void setUp() {
        TypeRecette testTypeRecette1 = new TypeRecette();
        testTypeRecette1.setRef("TestRef1");
        testTypeRecette1.setLibelle("TestLibelle1");
        typeRecetteDao.save(testTypeRecette1);

        TypeRecette testTypeRecette2 = new TypeRecette();
        testTypeRecette2.setRef("TestRef2");
        testTypeRecette2.setLibelle("TestLibelle2");
        typeRecetteDao.save(testTypeRecette2);
    }

    @AfterEach
    public void tearDown() {
        typeRecetteDao.deleteAll();
    }
    @Test
    public void testFindByRef() {
        ResponseEntity<TypeRecette> response = restTemplate.getForEntity("/api/type-recette/ref/{ref}", TypeRecette.class, "TestRef1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        TypeRecette typeRecette = response.getBody();
        assertNotNull(typeRecette);
        assertEquals("TestRef1", typeRecette.getRef());
        assertEquals("TestLibelle1", typeRecette.getLibelle());
    }

    @Test
    public void testFindAll() {
        ResponseEntity<TypeRecette[]> response = restTemplate.getForEntity("/api/type-recette/", TypeRecette[].class);
        List<TypeRecette> typeRecettes = Arrays.asList(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(typeRecettes);
        assertEquals(2, typeRecettes.size());
    }

    @Test
    public void testSave() {
        TypeRecette newTypeRecette = new TypeRecette();
        newTypeRecette.setRef("NewTestRef");

        ResponseEntity<Integer> response = restTemplate.postForEntity("/api/type-recette/", newTypeRecette, Integer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());

        TypeRecette savedTypeRecette = typeRecetteDao.findByRef("NewTestRef");
        assertNotNull(savedTypeRecette);
    }
    @Test
    public void testDeleteByRef() {
        ResponseEntity<Integer> response = restTemplate.exchange("/api/type-recette/ref/{ref}",
                org.springframework.http.HttpMethod.DELETE, null, Integer.class, "TestRef");
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNull(typeRecetteDao.findByRef("TestRef"));
    }



}