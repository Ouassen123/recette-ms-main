package com.example.recette.service.impl;

import com.example.recette.bean.TypeRecette;
import com.example.recette.dao.TypeRecetteDao;
import com.example.recette.service.facade.TypeRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRecetteServiceImpl implements TypeRecetteService {
    @Autowired
    private TypeRecetteDao typeRecetteDao;
    @Override
    public TypeRecette findByRef(String ref) {
        return typeRecetteDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return typeRecetteDao.deleteByRef(ref);
    }

    @Override
    public List<TypeRecette> findAll() {
        return typeRecetteDao.findAll();
    }

    @Override
    public int save(TypeRecette typeRecette) {
         typeRecetteDao.save(typeRecette);
        return 1;
    }

    @Override
    public int update(TypeRecette typeRecette) {
        if (typeRecetteDao.findByRef(typeRecette.getRef()) != null){
            TypeRecette tr = new TypeRecette();
            tr.setId(typeRecette.getId());
            tr.setRef(typeRecette.getRef());
            tr.setLibelle(typeRecette.getLibelle());
            tr.setImage(typeRecette.getImage());

            typeRecetteDao.save(tr);
            return 1;
        }
        return -1;
    }
}
