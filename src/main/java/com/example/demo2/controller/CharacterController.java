package com.example.demo2.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.example.demo2.model.CharacterResponse;
import com.example.demo2.CharacterDao;

import java.util.List;

@RestController
public class CharacterController {
    private final CharacterDao characterDao;
    @Value("${error.message}")
    private String errorMessage;

    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }
    ;
    @GetMapping("/")
    public List<CharacterResponse> getCharacter() {
        return characterDao.findAll();
    }

    @GetMapping("/{id}")
    public CharacterResponse getCharacterById( @PathVariable int id){
       return characterDao.findById(id);
    }
    @PostMapping("/")
    public CharacterResponse savePerson(@RequestBody CharacterResponse characterResponse) {
        Long id= characterDao.getMaxId()+1;
        characterResponse.setId(id);
            return characterDao.save(characterResponse);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteCharacterById( @PathVariable int id){
        return characterDao.delete(id);

    }
    @PutMapping("/update/{id}")
    public void changeCharacter( @PathVariable int id,@RequestBody CharacterResponse characterResponse){
         characterDao.update(id, characterResponse);
    }
}
