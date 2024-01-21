package com.example.recette.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtapeTest {

    @Test
    public void testEtapeProperties() {
        Etape etape = new Etape();
        etape.setId(1);
        etape.setRef("ETAPE123");
        etape.setDescription("Description de l'étape");
        etape.setOrdre(1);
        etape.setDuree(10);

        assertEquals(1, etape.getId());
        assertEquals("ETAPE123", etape.getRef());
        assertEquals("Description de l'étape", etape.getDescription());
        assertEquals(1, etape.getOrdre());
        assertEquals(10, etape.getDuree());
    }

}