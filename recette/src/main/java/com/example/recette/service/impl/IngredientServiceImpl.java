package com.example.recette.service.impl;

import com.example.recette.bean.Ingredient;
import com.example.recette.dao.IngredientDao;
import com.example.recette.service.facade.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        if (ingredientDao.findByRef(ref) != null) {
            ingredientDao.deleteByRef(ref);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int save(Ingredient ingredient) {
        ingredientDao.save(ingredient);
        return 1;
    }

    @Override
    @Transactional
    public int update(Ingredient ingredient) {
        Ingredient existingIngredient = ingredientDao.findByRef(ingredient.getRef());
        if (existingIngredient != null) {
            existingIngredient.setNom(ingredient.getNom());
            existingIngredient.setQuantite(ingredient.getQuantite());
            existingIngredient.setUnite(ingredient.getUnite());
            ingredientDao.save(existingIngredient);

            return 1;
        } else {
            return 0;
        }
    }
}
