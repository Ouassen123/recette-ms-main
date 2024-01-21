package com.example.recette.service.impl;

import com.example.recette.bean.Etape;
import com.example.recette.dao.EtapeDao;
import com.example.recette.service.facade.EtapeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtapeServiceImp implements EtapeService {
    @Autowired
    private EtapeDao etapeDao;


    @Override
    @Transactional
    public int deleteByRef(String ref) {
        if (etapeDao.findByRef(ref) != null) {
            etapeDao.deleteByRef(ref);
            return 1;
        } else return -1;
    }


    @Override
    public int save(Etape etape) {
        etapeDao.save(etape);
        return 1;
    }

    @Override
    @Transactional
    public int update(Etape etape) {
        Etape existingEtape = etapeDao.findByRef(etape.getRef());
        if (existingEtape != null) {
            existingEtape.setDescription(etape.getDescription());
            existingEtape.setOrdre(etape.getOrdre());
            existingEtape.setDuree(etape.getDuree());
            etapeDao.save(existingEtape);

            return 1;
        } else {
            return 0;
        }
    }
}
