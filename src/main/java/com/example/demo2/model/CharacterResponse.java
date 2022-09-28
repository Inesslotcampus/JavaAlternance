package com.example.demo2.model;
import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class CharacterResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "level_life")
    private  int levelLife;

    public CharacterResponse(int id, String name, String type, int levelLife) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.levelLife = levelLife;
    }
    public CharacterResponse() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getLevelLife() {
        return levelLife;
    }
    public void setLevelLife(int levelLife) {
        this.levelLife = levelLife;
    }
}
