/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Abilities;
import Modelo.Evolution;
import Modelo.Modelo;
import Modelo.Pokemon;
import Modelo.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author facue
 */
public class podekexTest {
    Modelo model = new Modelo();
    Pokemon pok = new Pokemon();
    Abilities abi = new Abilities();
    Evolution evo = new Evolution();
    Type ty = new Type();
    
    public podekexTest() {
        
    
   }        
    @Test
    public void testListPokemons()
    {
        System.out.println("podekexTest.testListPokemons()");
        int expected = 12;
        int totalPokemons = model.listAllPokemons();
        assertEquals(expected, totalPokemons);
        System.out.println("Total pokemons= " +totalPokemons);
        separador();
    }
    @Test
    public void testGetPokemonByName()
    {
        System.out.println("podekexTest.testGetPokemonByName()");
        List<String> res = new ArrayList<String>();
        res = model.verifyPokemonInfoByName("Pikachu");
        System.out.println(res.get(0));
        pok.setName(res.get(0));
        ty.setName(res.get(1));
        
        String expectedName = "Pikachu";
        String expectedType = "electric";
        
        assertEquals(expectedName, pok.getName());
        assertEquals(expectedType, ty.getName());
        
        System.out.println("Nombre del pokemon: "+pok.getName());
        System.out.println("Nombre de tipo: "+ty.getName());
            
        separador();
    }
    @Test
    public void testGetPokemonEvolutions()
    {
        System.out.println("podekexTest.testGetPokemonEvolutions()");
        List<String> evolutions = new ArrayList<String>(model.cargarEvolutionsByName("Pikachu"));
        String expectedName = "Raichu";
        String expectedLvl = "16";
        
        assertEquals(expectedName, evolutions.get(0));
        assertEquals(expectedLvl, evolutions.get(1));
        
        System.out.println("Nombre Pokemon: Pikachu");
        System.out.println("Nombre evolución: " +evolutions.get(0));
        System.out.println("Nivel evolución: " +evolutions.get(1));
        
        separador();
    }
    @Test
    public void testAddAndRetrievePokemon()
    {
        System.out.println("podekexTest.testAddAndRetrievePokemon()");
        model.addPokemonByName("testPokemon");
        boolean expected = true;
        System.out.println("El pokemon añadido es: testPokemon");
        System.out.println("¿El pokemon está en la base de datos?: " + model.returnPokemonByName("testPokemon"));
        assertEquals(expected, model.returnPokemonByName("testPokemon"));
        model.borrarPokemon("testPokemon");
        System.out.println("Eliminando pokemon de test");
        System.out.println("¿El pokemon está en la base de datos?: " + model.returnPokemonByName("testPokemon"));

        separador();
    }
    @Test
    public void testChangeName() {
        System.out.println("podekexTest.testChangeName()");
        model.changePokemonName("Pikachu", "Kachupi");
        System.out.println("¿El pokemon Pikachu ahora se llama Kachupi?: "+ model.returnPokemonByName("Kachupi"));
        System.out.println("¿El pokemon aún se llama Pikachu?: "+ model.returnPokemonByName("Pikachu"));
        System.out.println("Deshaciendo cambios..");
        model.changePokemonName("Kachupi", "Pikachu");
        System.out.println("¿El pokemon Pikachu ahora se llama Kachupi?: "+ model.returnPokemonByName("Kachupi"));
        System.out.println("¿El pokemon ahora se llama Pikachu?: "+ model.returnPokemonByName("Pikachu"));
        
        separador();
        
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before class");
    }
    
    @AfterClass
    public static void tearDownClass() {

        System.out.println("After class");
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        abi.setId(0);
        abi.setName(null);
        pok.setId(0);
        pok.setName(null);
        evo.setId(0);
        evo.setName(null);
        ty.setId(0);
        ty.setName(null);
        
    }
    public void separador()
    {
        System.out.printf("\n===========================\n\n");
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
