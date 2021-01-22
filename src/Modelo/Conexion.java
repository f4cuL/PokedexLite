/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
   
    private Connection con;
    
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex","root","");
        } catch (Exception e) {
            System.out.println("Erorr en base de datos "+e);
        }
    }  
    public Connection getConexion()
    {
        return con;
    }
 
}