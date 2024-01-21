package com.example.recette.service.impl;

import com.example.recette.bean.Recette;
import com.example.recette.dao.RecetteDao;
import com.example.recette.required.UserRequired;
import com.example.recette.service.facade.*;
import com.example.recette.vo.ResponseEntity;
import com.example.recette.vo.UserVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecetteServiceImpl implements RecetteService {
    @Autowired
    private UserRequired userRequired;
    @Autowired
    private RecetteDao recetteDao;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private EtapeService etapeService;
    @Autowired
    private TypeRecetteService typeRecetteService;

    @Override
    public Recette findByRef(String ref) {
        return recetteDao.findByRef(ref);
    }

    @Override
    public List<ResponseEntity> findByUserRef(String userRef) {
        List<ResponseEntity> responseEntities = new ArrayList<>();
        List<Recette> recettes = recetteDao.findByUserRef(userRef);
        for (Recette recette : recettes) {
            UserVo userVo = userRequired.findByRef(recette.getUserRef());
            responseEntities.add(new ResponseEntity(recette, userVo));
        }

        return responseEntities;
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return recetteDao.deleteByRef(ref);
    }

    @Override
    public List<ResponseEntity> findAll() {
        List<ResponseEntity> responseEntities = new ArrayList<>();
        List<Recette> recettes = recetteDao.findAll();

        for (Recette recette : recettes) {
            UserVo userVo = userRequired.findByRef(recette.getUserRef());
            responseEntities.add(new ResponseEntity(recette, userVo));
        }

        return responseEntities;
    }

    @Override
    public int save(Recette recette) {
        recette.getIngredients().forEach(ingredient -> ingredientService.save(ingredient));
        recette.getEtapes().forEach(etape -> etapeService.save(etape));
        recetteDao.save(recette);
        return 1;
    }

    @Override
    public int save1(Recette recette) {
        if (recetteDao.findByRef(recette.getRef()) != null) {
            if (recette.getIngredients() != null) {
                recette.getIngredients().forEach(ingredient -> ingredientService.save(ingredient));
            }
            if (recette.getEtapes() != null) {
                recette.getEtapes().forEach(etape -> etapeService.save(etape));
            }
            if (userRequired.findByRef(recette.getUserRef()) != null) {
                recetteDao.save(recette);
            }
            return 1;
        }
        return -1;
    }


    @Override
    public int update(Recette recette) {
        if (recetteDao.findByRef(recette.getRef()) != null) {
            Recette r = new Recette();
            r.setId(recette.getId());
            r.setRef(recette.getRef());
            r.setDuree(recette.getDuree());
            r.setDescription(recette.getDescription());
            r.setUserRef(recette.getUserRef());
            r.setDate_publication(new Date());
            r.setIngredients(recette.getIngredients());
            r.setEtapes(recette.getEtapes());
            r.setNom(recette.getNom());
            r.setImage(recette.getImage());

            r.setTypeRecette(recette.getTypeRecette());
            recetteDao.save(r);
            return 1;
        }
        return -1;
    }

    @Override
    public List<Recette> findAllByTypeRecetteRef(String ref) {
        if (typeRecetteService.findByRef(ref) != null) {
            return recetteDao.findAllByTypeRecetteRef(ref);
        } else return null;
    }


}
