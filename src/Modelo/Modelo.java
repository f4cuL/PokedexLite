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
    private Evolution auxEvo;

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

    public int verifyLogin(Users user) {
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from usuarios where user=? and password=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void listMyPokemons(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select p.id, p.name, up.lvlFound from pokemon p inner join user_pokemons up on up.idPokemon=p.id where up.idCliente=" + auxUsuario.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[3];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            rs = ps.executeQuery(sql);
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

    public void cargarTablaType(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select t.name from type t inner join pokemon_type pt on pt.idType=t.id "
                + "inner join pokemon p on p.id=pt.idPkm where p.id=" + auxPokemon.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[2];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            while (rs.next()) {
                pokemon[0] = rs.getString("name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarTablaEvolutions(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select e.name from evolution e inner join evolution_pkm ep on e.id=ep.idEvo "
                + "inner join pokemon p on p.id=ep.idPkm where p.id=" + auxPokemon.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[1];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            while (rs.next()) {
                pokemon[0] = rs.getString("name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarTablaAbilities(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select a.name from abilities a inner join pokemon_abilities pa on pa.idAbilitie=a.id "
                + "inner join pokemon p on p.id=pa.idPkm where p.id=" + auxPokemon.getId();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] pokemon = new Object[1];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            while (rs.next()) {
                pokemon[0] = rs.getString("name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Pokemon createPokemonObject(int id) {
        String sql = "select p.id, p.name from pokemon p inner join user_pokemons up on up.idPokemon=p.id where p.id=" + id;
        try {
            Pokemon po = new Pokemon();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                po.setId(rs.getInt("p.id"));
                po.setName(rs.getString("p.name"));
                return po;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Pokemon createPokemonObjectAll(int id) {
        String sql = "select p.id, p.name from pokemon p where p.id=" + id;
        try {
            Pokemon po = new Pokemon();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                po.setId(rs.getInt("p.id"));
                po.setName(rs.getString("p.name"));
                return po;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Evolution createObjectEvolution(String name) {
        String sql = "select e.id, e.name from evolution e inner join evolution_pkm ep on e.id=ep.idEvo inner join pokemon p"
                + " on p.id =ep.idPkm where e.name='" + name + "'";
        try {
            Evolution evo = new Evolution();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                evo.setId(rs.getInt("e.id"));
                evo.setName(rs.getString("e.name"));
            }
            return evo;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void cargarTablaEvoType(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select t.name from type t inner join evolution_type et on et.idType=t.id "
                + "inner join evolution e on e.id=et.idEvo where e.id=" + auxEvo.getId();
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
                pokemon[0] = rs.getString("t.name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarTablaEvoAbilities(JTable tabla) {
        limpiarTabla(tabla);
        String sql = "select a.name from abilities a inner join evolution_abilities ea on ea.idAbilitie=a.id "
                + "inner join evolution e on e.id=ea.idEvo where e.id=" + auxEvo.getId();
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
                pokemon[0] = rs.getString("a.name");
                modelo.addRow(pokemon);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean addPokemon() {
        String sql = "insert into pokemon(name) values(?)";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, controlador.getNewPokemon().getTxtNewPkm().getText());
            ps.execute();
            listAllPokemons(controlador.getAllPokemons().getTablaAllPkm());
            controlador.getNewPokemon().getTxtNewPkm().setText(null);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Evolution getAuxEvo() {
        return auxEvo;
    }
    
    public void setAuxEvo(Evolution auxEvo) {
        this.auxEvo = auxEvo;
    }
    
    public void btnTypes()
    {
      String sql="select name from type";
      PreparedStatement ps = null;
      ResultSet rs = null;
      Connection con= conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
               controlador.getAllPokemonsAddType().getTypeComboBox().addItem(rs.getString("name"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }
    public int getIdFromPokemonType(String name)
    {
        String sql="select id from type where name='"+name+"'";
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con = conexion.getConexion();
        int id=0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
             id = rs.getInt("id");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return(id);
    }
    public boolean addType(int id)
    {
        //String sql="insert into "
        return true;
    }
}
