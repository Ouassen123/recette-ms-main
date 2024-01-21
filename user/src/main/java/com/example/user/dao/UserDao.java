package com.example.user.dao;

import com.example.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByRef(String ref);
    List<User> findByEmail(String email);
    User findFirstByEmail(String email);
    int deleteByRef(String ref);
}
