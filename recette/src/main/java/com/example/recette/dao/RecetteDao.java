package com.example.recette.dao;

import com.example.recette.bean.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteDao extends JpaRepository<Recette,Integer> {
    Recette findByRef(String ref);
    int deleteByRef(String ref);
    List<Recette> findByUserRef(String userRef);
    List<Recette> findAllByTypeRecetteRef(String ref);

}
