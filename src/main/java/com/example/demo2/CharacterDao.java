package com.example.demo2;
import com.example.demo2.model.CharacterResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CharacterDao {
    List<CharacterResponse> findAll();
    CharacterResponse findById(int id);
    CharacterResponse save(CharacterResponse characterResponse);
    boolean delete(int id);

    CharacterResponse update(int id, @RequestBody CharacterResponse characterResponse);
    Long getMaxId();
}
