package com.example.demo2.controller;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import com.example.demo2.model.CharacterResponse;
import com.example.demo2.CharacterDao;

import java.util.List;

@Api("API pour les opérations CRUD sur les personnages.")
@RestController
@RequestMapping("/api/characters/")
public class CharacterController {
    @Autowired
    private final CharacterDao characterDao;
    @Value("${error.message}")
    private String errorMessage;
    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    };
    @ApiOperation(value = "Récupère tous les personnages")
    @GetMapping("/")
    public List<CharacterResponse> getCharacter() {
        List<CharacterResponse> characters= characterDao.findAll();
        return characters;
    }
    @ApiOperation(value = "Récupère un personnage grace à son id")
    @GetMapping("/{id}")
    public CharacterResponse getCharacterById( @PathVariable int id){
       return characterDao.findById(id);
    }
    @ApiOperation(value = "Enregistre un nouveau personnage")
    @PostMapping("/")
    public void savePerson(@RequestBody CharacterResponse characterResponse) {
            characterDao.save(characterResponse);
    }
    @ApiOperation(value = "supprime un personnage grace à son id")
    @DeleteMapping("/{id}")
    public void deleteCharacterById( @PathVariable int id){
         characterDao.deleteById(id);
    }
    @ApiOperation(value = "modifie un personnage")
    @PutMapping("/{id}")
    public void changeCharacter( @PathVariable int id,@RequestBody CharacterResponse characterResponse){
        characterResponse.setId(id);
         characterDao.save( characterResponse);
    }
}
