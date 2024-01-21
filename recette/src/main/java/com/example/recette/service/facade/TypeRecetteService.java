package com.example.recette.service.facade;
import com.example.recette.bean.TypeRecette;

import java.util.List;

public interface TypeRecetteService {
    TypeRecette findByRef(String ref);
    int deleteByRef(String ref);
    List<TypeRecette> findAll();
    int save(TypeRecette typeRecette);
    int update(TypeRecette typeRecette);
}
