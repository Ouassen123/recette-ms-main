package com.example.user.service.facade;

import com.example.user.bean.User;

import java.util.List;

public interface UserService {
    User findByRef(String ref);
    int deleteByRef(String ref);
    List<User> findAll();
    User save(User user);
    User authentification(User user);

    int update(User user);
}
