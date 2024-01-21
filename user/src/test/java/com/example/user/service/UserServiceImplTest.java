package com.example.user.service;

import com.example.user.bean.User;
import com.example.user.dao.UserDao;
import com.example.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

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
        User retrievedUser = userService.findByRef("XS12SLH0");
        assertEquals("SOULOH", retrievedUser.getNom());
        assertEquals("Abdellah", retrievedUser.getPrenom());
        assertEquals("souloh@gmail.com", retrievedUser.getEmail());
    }

    @Test
    public void testDeleteByRef() {
        int result = userService.deleteByRef("XS12SLH0");
        assertEquals(1, result);
        assertNull(userService.findByRef("XS12SLH0"));
    }

}
