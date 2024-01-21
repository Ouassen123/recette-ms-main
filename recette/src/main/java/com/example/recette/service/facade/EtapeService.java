package com.example.recette.service.facade;

import com.example.recette.bean.Etape;


public interface EtapeService {
    int deleteByRef(String ref);

    int save(Etape etape);


    int update(Etape etape);
}
