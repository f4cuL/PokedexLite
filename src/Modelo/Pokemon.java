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
public abstract class Pokemon {
    private String name;
    private String [] type;
    private int levelFounded;
    private Evolutions [] evolutions;
    private Abilities[] abilites;

    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public int getLevelFounded() {
        return levelFounded;
    }

    public void setLevelFounded(int levelFounded) {
        this.levelFounded = levelFounded;
    }

    public Evolutions[] getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(Evolutions[] evolutions) {
        this.evolutions = evolutions;
    }
    
   
    
}
