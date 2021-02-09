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
        int expected = 12;
        int totalPokemons = model.listAllPokemons();
        assertEquals(expected, totalPokemons);
    }
    @Test
    public void testGetPokemonByName()
    {
        List<String> res = new ArrayList<String>();
        res = model.verifyPokemonInfoByName("Pikachu");
        System.out.println(res.get(0));
        pok.setName(res.get(0));
        ty.setName(res.get(1));
        
        String expectedName = "Pikachu";
        String expectedType = "electric";
        
        assertEquals(expectedName, pok.getName());
        assertEquals(expectedType, ty.getName());
            
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
        System.out.println("Empezando test");
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
        System.out.println("Terminando test");
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
