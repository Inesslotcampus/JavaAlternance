package com.example.demo2;

import com.example.demo2.model.CharacterResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


@Repository
public class CharacterDaoImpl implements CharacterDao {
    public static List<CharacterResponse> characteresResponse = new ArrayList<>();

    static {
        characteresResponse.add(new CharacterResponse(1, "david", "mage", 1));
        characteresResponse.add(new CharacterResponse(2, " david", "mage", 2));
        characteresResponse.add(new CharacterResponse(3, "david", "mage", 3));
    }

    @Override
    public List<CharacterResponse> findAll() {
        return characteresResponse;
    }

    @Override
    public CharacterResponse findById(int id) {
        for (CharacterResponse characterResponse : characteresResponse) {
            if (characterResponse.getId() == id) {
                return characterResponse;
            }
        }
        return null;
    }

    @Override
    public CharacterResponse save(CharacterResponse characterResponse) {
        characteresResponse.add(characterResponse);
        return characterResponse;
    }

    @Override
    public Long getMaxId() {
        return characteresResponse.stream().map(el -> el.getId()).max(Long::compare).get();
    }

    @Override
    public boolean delete(int id) {
        characteresResponse = characteresResponse.stream().filter(el -> el.getId() != id).collect(Collectors.toList());
        return true;
    }

    @Override
    public CharacterResponse update(int id, @RequestBody CharacterResponse characterResponse) {
        CharacterResponse characterUpdate = characteresResponse.stream().filter(el -> el.getId() == id).findFirst().orElse(null);
        characterUpdate.setName(characterResponse.getName());
        characterUpdate.setType(characterResponse.getType());
        characterUpdate.setLevelLife(characterResponse.getLevelLife());
        return characterUpdate;

    }
}
