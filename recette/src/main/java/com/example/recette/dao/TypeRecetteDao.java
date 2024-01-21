package com.example.recette.dao;

import com.example.recette.bean.TypeRecette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRecetteDao extends JpaRepository<TypeRecette,Integer> {
    TypeRecette findByRef(String ref);
    int deleteByRef(String ref);
}
