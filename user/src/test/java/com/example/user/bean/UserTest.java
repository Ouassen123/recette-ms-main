package com.example.user.bean;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {
    @Test
    public void testUserProperties() {
        User user = new User(1, "SLH", "sol", "abde", "soloh@gmail.com", "1234");
        assertEquals(1, user.getId());
        assertEquals("SLH", user.getRef());
        assertEquals("sol", user.getNom());
        assertEquals("abde", user.getPrenom());
        assertEquals("soloh@gmail.com", user.getEmail());
        assertEquals("1234", user.getPassword());
    }

}
