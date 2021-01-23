/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author facue
 */
public class Pokemon {
    private int id;
    private String name;
    private int levelFounded;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getLevelFounded() {
        return levelFounded;
    }

    public void setLevelFounded(int levelFounded) {
        this.levelFounded = levelFounded;
    }
  
}
