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
import java.io.File;
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

    }
    @Test
    public void testGetPokemonEvolutionsAndAbilities()
    {
        System.out.println("podekexTest.testGetPokemonEvolutionsAndAbilities()");
        List<String> type = new ArrayList<String>(model.getEvolutions("Pikachu"));
        List<String> abilities = new ArrayList<String>(model.getAbilities("Pikachu"));
        for (String i : type)
        {
            System.out.println(i);
        }
        for (String i : abilities)
        {
            System.out.println(i);
        }
        String expectedName = "Raichu";
        String expectedAbilitie = "Static";
        
        
        
        assertEquals(expectedName, type.get(0));
        assertEquals(expectedAbilitie, abilities.get(0));
       

    }
    
    @Test
     public void testEvolutionTypeAndAbilities()
    {
        System.out.println("podekexTest.testEvolutionTypeAndAbilities()");
        List<String> res = new ArrayList<String>(model.EvolutionsType("Pikachu"));
        List<String> resAbi = new ArrayList<String>(model.EvolutionsAbiltiies("Pikachu"));
        int cont=0;
        for (String i : res)
        {
            if(cont==0){
                System.out.printf("Nombre pokemon: ");
            }
            System.out.println(i);
            cont++;
        }
         for (String i : resAbi)
        {
            System.out.println(i);
        }
        
        String expectedName = "Raichu";
        String expectedType = "electric";
        String expectedAbilitie = "Static";
        String expectedLevel ="16";
        
        assertEquals(expectedName, res.get(0));
        assertEquals(expectedType, res.get(1));
        assertEquals(expectedLevel, res.get(2));
        assertEquals(expectedAbilitie, resAbi.get(0));


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

    }
    @Test
    public void testChangeName() {
        System.out.println("podekexTest.testChangeName()");
        model.changePokemonName("Pikachu", "Kachupi");
        System.out.println("¿El pokemon Pikachu ahora se llama Kachupi?: "+ model.returnPokemonByName("Kachupi"));
        System.out.println("¿El pokemon aún se llama Pikachu?: "+ model.returnPokemonByName("Pikachu"));
        
        boolean expectedNameStatus = true;
        assertEquals(expectedNameStatus, model.returnPokemonByName("Kachupi"));
        
        System.out.println("Deshaciendo cambios..");
        
        model.changePokemonName("Kachupi", "Pikachu");
        
        System.out.println("¿El pokemon Pikachu ahora se llama Kachupi?: "+ model.returnPokemonByName("Kachupi"));
        System.out.println("¿El pokemon ahora se llama Pikachu?: "+ model.returnPokemonByName("Pikachu"));
        

        
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
        separador();
        
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
