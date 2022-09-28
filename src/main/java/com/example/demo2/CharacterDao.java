package com.example.demo2;
import com.example.demo2.model.CharacterResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CharacterDao extends JpaRepository<CharacterResponse, Integer>{
    CharacterResponse findById(int id);
    List<CharacterResponse> findAll();

//    boolean deleteById(int id);
//
//    CharacterResponse update(int id, @RequestBody CharacterResponse characterResponse);

}
