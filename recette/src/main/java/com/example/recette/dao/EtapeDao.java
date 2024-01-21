package com.example.recette.dao;

import com.example.recette.bean.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeDao extends JpaRepository<Etape, Long> {
    Etape findByRef(String ref);

    int deleteByRef(String ref);
}

