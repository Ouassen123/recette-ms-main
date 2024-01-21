package com.example.recette.ws.provided;

import com.example.recette.bean.Recette;
import com.example.recette.service.facade.RecetteService;
import com.example.recette.vo.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/recette")
public class RecetteWs {
    @Autowired
    private RecetteService recetteService;

    @GetMapping("/ref/{ref}")
    public Recette findByRef(@PathVariable String ref) {
        return recetteService.findByRef(ref);
    }

    @GetMapping("/user-id/{userRef}")
    public List<ResponseEntity> findByUserId(@PathVariable String userRef) {
        return recetteService.findByUserRef(userRef);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return recetteService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<ResponseEntity> findAll() {
        return recetteService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Recette recette) {
        return recetteService.save(recette);
    }

    @PostMapping("/save")
    public int save1(@RequestBody Recette recette) {
        return recetteService.save1(recette);
    }

    @PutMapping("/")
    public int update(@RequestBody Recette recette) {
        return recetteService.update(recette);
    }

    @GetMapping("/type-recette/ref/{ref}")
    public List<Recette> findAllByTypeRecetteRef(@PathVariable String ref) {
        return recetteService.findAllByTypeRecetteRef(ref);
    }
}
