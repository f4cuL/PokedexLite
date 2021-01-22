/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Principal;
import Vista.allPokemons;
import Vista.login;
import Vista.myPokemons;
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
