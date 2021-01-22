/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexlitecertant;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Principal;
import Vista.allPokemons;
import Vista.login;
import Vista.myPokemons;

/**
 *
 * @author facue
 */
public class PokedexLiteCertant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creación de vistas, modelo y controlador
        login login = new login();
        Controlador controlador = new Controlador();
        Modelo modelo = new Modelo();
        Principal principal = new Principal();
        myPokemons mypk = new myPokemons();
        allPokemons allPkm = new allPokemons();
        
        //Set de controlador
        controlador.setLogin(login);
        controlador.setModelo(modelo);
        controlador.setPrincipal(principal);
        controlador.setMyPokemons(mypk);
        controlador.setAllPokemons(allPkm);
        
        //Set de vistas y modelo
        login.setControlador(controlador);
        modelo.setControlador(controlador);
        principal.setControlador(controlador);
        mypk.setControlador(controlador);
        allPkm.setControlador(controlador);
        
        //
        login.setVisible(true);
        
    }
    
}
