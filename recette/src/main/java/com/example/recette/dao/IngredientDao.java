package com.example.recette.dao;

import com.example.recette.bean.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient,Integer> {
    int deleteByRef(String ref);
    Ingredient findByRef(String ref);

}
