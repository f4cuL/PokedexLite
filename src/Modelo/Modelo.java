/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author facue
 */
public class Modelo {
    private Controlador controlador;
    private Conexion conexion;
    private Users auxUsuario;
    private Pokemon auxPokemon;

    public Pokemon getAuxPokemon() {
        return auxPokemon;
    }

    public void setAuxPokemon(Pokemon auxPokemon) {
        this.auxPokemon = auxPokemon;
    }

    public Modelo() {
      conexion = new Conexion();
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public Users getAuxUsuario() {
        return auxUsuario;
    }

    public void setAuxUsuario(Users auxUsuario) {
        this.auxUsuario = auxUsuario;
    }
    

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public int verifyLogin(Users user)
    {
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from usuarios where user=? and password=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs= ps.executeQuery();
            if (rs.next())
            {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
   }
    public void listMyPokemons(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select p.id, p.name, up.lvlFound from pokemon p inner join user_pokemons up on up.idPokemon=p.id where up.idCliente="+auxUsuario.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[3];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            rs = ps.executeQuery(sql);
            System.out.println(auxUsuario.getId());
            while (rs.next()) {
                pokemon[0] = rs.getString("id");
                pokemon[1] = rs.getString("name");
                pokemon[2] = rs.getString("lvlFound");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      public void listAllPokemons(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select * from pokemon";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[2];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                pokemon[0] = rs.getInt("id");
                pokemon[1] = rs.getString("name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void limpiarTabla(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            DefaultTableModel tabla2 = (DefaultTableModel) tabla.getModel();
            tabla2.removeRow(i);
            i = i - 1;
        }
    }
    public void cargarTablaType (JTable tabla){
        limpiarTabla(tabla);
        controlador.getUserPokemonInfo().getLblName().setText(auxPokemon.getName());
        String sql = "select t.name from type t inner join pokemon_type pt on pt.idType=t.id "
                + "inner join pokemon p on p.id=pt.idPkm where p.id="+auxPokemon.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[2];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                pokemon[0] = rs.getString("name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }      
      public void cargarTablaEvolutions (JTable tabla){
        limpiarTabla(tabla);
        String sql = "select e.name from evolution e inner join evolution_pkm ep on e.id=ep.idEvo "
                + "inner join pokemon p on p.id=ep.idPkm where p.id="+auxPokemon.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[2];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                pokemon[0] = rs.getString("name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
      public Pokemon createPokemonObject(int id)
      {
          String sql = "select p.id, p.name from pokemon p inner join user_pokemons up on up.idPokemon=p.id where p.id="+id; 
          try {
            Pokemon po = new Pokemon();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                po.setId(rs.getInt("p.id"));
                po.setName(rs.getString("p.name"));
                return po;
            }
          }
            catch (Exception e) {
            System.out.println(e);
        }
          return null;
      }
    }  
