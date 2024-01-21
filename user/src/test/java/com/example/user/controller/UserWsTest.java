package com.example.user.controller;

import com.example.user.bean.User;
import com.example.user.dao.UserDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserWsTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UserDao userDao;

    @BeforeEach
    public void setUp() {
        User testUser = new User(1, "XS12SLH0", "SOULOH", "Abdellah", "souloh@gmail.com", "1234");
        userDao.save(testUser);
    }

    @AfterEach
    public void tearDown() {
        userDao.deleteAll();
    }

    @Test
    public void testFindByRef() {
        ResponseEntity<User> response = restTemplate.getForEntity("/api/user/ref/{ref}", User.class, "XS12SLH0");
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("SOULOH", response.getBody().getNom());
        assertEquals("Abdellah", response.getBody().getPrenom());
        assertEquals("souloh@gmail.com", response.getBody().getEmail());
    }

    @Test
    public void testDeleteByRef() {
        ResponseEntity<Integer> response = restTemplate.exchange("/api/user/ref/{ref}", HttpMethod.DELETE, null, Integer.class, "XS12SLH0");
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody());
    }

}
