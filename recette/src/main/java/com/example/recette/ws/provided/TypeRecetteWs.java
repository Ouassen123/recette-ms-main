package com.example.recette.ws.provided;

import com.example.recette.bean.TypeRecette;
import com.example.recette.service.facade.TypeRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/type-recette")
public class TypeRecetteWs {
    @Autowired
    private TypeRecetteService typeRecetteService;

    @GetMapping("/ref/{ref}")
    public TypeRecette findByRef(@PathVariable String ref) {
        return typeRecetteService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return typeRecetteService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<TypeRecette> findAll() {
        return typeRecetteService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TypeRecette typeRecette) {
        return typeRecetteService.save(typeRecette);
    }

    @PutMapping("/")
    public int update(@RequestBody TypeRecette typeRecette) {
        return typeRecetteService.update(typeRecette);
    }
}
