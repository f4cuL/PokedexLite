/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Principal;
import Vista.allPokemons;
import Vista.allPokemonsAddType;
import Vista.allPokemonsAddTypeEvo;
import Vista.allPokemonsInfo;
import Vista.allPokemonsModifyEvolution;
import Vista.login;
import Vista.myPokemons;
import Vista.newAbilitie;
import Vista.newEvolution;
import Vista.newPokemon;
import Vista.userEvolutionInfo;
import Vista.userPokemonInfo;

/**
 *
 * @author facue
 */
public class Controlador {
   private login login;
   private Modelo modelo;
   private Principal principal;
   private myPokemons myPokemons;
   private allPokemons allPokemons;
   private userPokemonInfo userPokemonInfo;
   private userEvolutionInfo userEvolutionInfo;
   private newPokemon newPokemon;
   private newEvolution newEvolution;
   private allPokemonsInfo allPokemonsInfo;
   private allPokemonsAddType allPokemonsAddType;
   private newAbilitie newAbilitie;
   private allPokemonsModifyEvolution allPokemonsModifyEvolution;
   private allPokemonsAddTypeEvo allPokemonsAddTypeEvo;

    public allPokemonsAddTypeEvo getAllPokemonsAddTypeEvo() {
        return allPokemonsAddTypeEvo;
    }

    public void setAllPokemonsAddTypeEvo(allPokemonsAddTypeEvo allPokemonsAddTypeEvo) {
        this.allPokemonsAddTypeEvo = allPokemonsAddTypeEvo;
    }
   

    public allPokemonsModifyEvolution getAllPokemonsModifyEvolution() {
        return allPokemonsModifyEvolution;
    }

    public void setAllPokemonsModifyEvolution(allPokemonsModifyEvolution allPokemonsModifyEvolution) {
        this.allPokemonsModifyEvolution = allPokemonsModifyEvolution;
    }

    public newAbilitie getNewAbilitie() {
        return newAbilitie;
    }

    public void setNewAbilitie(newAbilitie newAbilitie) {
        this.newAbilitie = newAbilitie;
    }
   
    public allPokemonsAddType getAllPokemonsAddType() {
        return allPokemonsAddType;
    }

    public newEvolution getNewEvolution() {
        return newEvolution;
    }

    public void setNewEvolution(newEvolution newEvolution) {
        this.newEvolution = newEvolution;
    }
    

    public void setAllPokemonsAddType(allPokemonsAddType allPokemonsAddType) {
        this.allPokemonsAddType = allPokemonsAddType;
    }

    public allPokemonsInfo getAllPokemonsInfo() {
        return allPokemonsInfo;
    }

    public void setAllPokemonsInfo(allPokemonsInfo allPokemonsInfo) {
        this.allPokemonsInfo = allPokemonsInfo;
    }
   

    public newPokemon getNewPokemon() {
        return newPokemon;
    }

    public void setNewPokemon(newPokemon newPokemon) {
        this.newPokemon = newPokemon;
    }

    public userEvolutionInfo getUserEvolutionInfo() {
        return userEvolutionInfo;
    }

    public void setUserEvolutionInfo(userEvolutionInfo userEvolutionInfo) {
        this.userEvolutionInfo = userEvolutionInfo;
    }

    public userPokemonInfo getUserPokemonInfo() {
        return userPokemonInfo;
    }

    public void setUserPokemonInfo(userPokemonInfo userPokemonInfo) {
        this.userPokemonInfo = userPokemonInfo;
    }

    public allPokemons getAllPokemons() {
        return allPokemons;
    }

    public void setAllPokemons(allPokemons allPokemons) {
        this.allPokemons = allPokemons;
    }

    public myPokemons getMyPokemons() {
        return myPokemons;
    }

    public void setMyPokemons(myPokemons myPokemons) {
        this.myPokemons = myPokemons;
    }
   
    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public login getLogin() {
        return login;
    }

    public void setLogin(login login) {
        this.login = login;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
   
    
}
