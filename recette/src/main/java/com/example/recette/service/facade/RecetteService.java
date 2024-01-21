package com.example.recette.service.facade;

import com.example.recette.bean.Recette;
import com.example.recette.vo.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecetteService {
    Recette findByRef(String ref);
    List<ResponseEntity> findByUserRef(String userRef);
    int deleteByRef(String ref);
    List<ResponseEntity> findAll();
    int save(Recette recette);
    int save1(Recette recette);
    int update(Recette recette);
    List<Recette> findAllByTypeRecetteRef(String ref);

}
