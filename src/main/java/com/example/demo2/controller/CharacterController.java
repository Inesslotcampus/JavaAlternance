package com.example.demo2.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.example.demo2.model.CharacterResponse;
import com.example.demo2.CharacterDao;

import java.util.List;

@Api("API pour les opérations CRUD sur les personnages.")
@RestController
@RequestMapping("/api/characters/")
public class CharacterController {
    private final CharacterDao characterDao;
    @Value("${error.message}")
    private String errorMessage;

    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }
    ;

    @ApiOperation(value = "Récupère tous les personnages")
    @GetMapping("/")
    public List<CharacterResponse> getCharacter() {
        return characterDao.findAll();
    }

    @ApiOperation(value = "Récupère un personnage grace à son id")
    @GetMapping("/{id}")
    public CharacterResponse getCharacterById( @PathVariable int id){
       return characterDao.findById(id);
    }
    @ApiOperation(value = "Enregistre un nouveau personnage")
    @PostMapping("/")
    public CharacterResponse savePerson(@RequestBody CharacterResponse characterResponse) {
        Long id= characterDao.getMaxId()+1;
        characterResponse.setId(id);
            return characterDao.save(characterResponse);
    }
    @ApiOperation(value = "supprime un personnage grace à son id")
    @DeleteMapping("/{id}")
    public boolean deleteCharacterById( @PathVariable int id){
        return characterDao.delete(id);

    }
    @ApiOperation(value = "modifie un personnage")
    @PutMapping("/{id}")
    public void changeCharacter( @PathVariable int id,@RequestBody CharacterResponse characterResponse){
         characterDao.update(id, characterResponse);
    }
}
