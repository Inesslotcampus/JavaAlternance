package com.example.demo2.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo2.CharacterResponse;

@RestController
public class CharacterController {

    @GetMapping("/characteres")
    public CharacterResponse listeCharacteres() {
        CharacterResponse CharacterResponse = new CharacterResponse(1,"David", "moldu",1);
        return CharacterResponse;
    }
}
