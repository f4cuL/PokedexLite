/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Type auxType;
    private Abilities auxAbi;

    public Type getAuxType() {
        return auxType;
    }

    public void setAuxType(Type auxType) {
        this.auxType = auxType;
    }
    
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
    
    public List<String> verifyPokemonInfoByName(String name)
    {
        List<String> resultado = new ArrayList<String>();
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql= "select p.name, t.name from pokemon p inner join pokemon_type pt on p.id=pt.idPkm inner join type t on pt.idType = t.id where p.name='"+name+"'";
        try {
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next())
            {
               resultado.add(rs.getString("p.name"));
               resultado.add(rs.getString("t.name"));
            }
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            
        }
        return null;
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

    public int listAllPokemons() {
        String sql = "select count(*) as cantidad from pokemon";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("cantidad");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<String> cargarEvolutionsByNameAndAbilities(String name) {
        List<String> lstEvolutions = new ArrayList<String>();
        String sql = "select e.name, e.lvlEvolve, a.name from evolution e inner join evolution_pkm ep on e.id=ep.idEvo "
                + "inner join pokemon p on p.id=ep.idPkm inner join pokemon_abilities pa on pa.idPkm=p.id inner join abilities a on pa.idAbilitie=a.id where p.name='" + name + "'";
        int i = 0;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (i == 0) {
                    lstEvolutions.add(rs.getString("e.name"));
                }
                lstEvolutions.add(rs.getString("e.lvlEvolve"));
                lstEvolutions.add(rs.getString("a.name"));
                i++;
            }
            return lstEvolutions;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
        public List<String> EvolutionsTypeAndAbilities(String name) {
        List<String> lstEvolutions = new ArrayList<String>();
        String sql = "select e.name, t.name, a.name from evolution e inner join evolution_pkm ep on e.id=ep.idEvo inner join evolution_type et on et.idEvo = e.id inner join "
                + " type t on t.id = et.idType inner join evolution_abilities ea on ea.idEvo = e.id inner join abilities a on a.id=ea.idAbilitie inner join pokemon p on ep.idPkm = p.id where p.name='"+name+"'";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lstEvolutions.add(rs.getString("e.name"));
                lstEvolutions.add(rs.getString("t.name"));
                lstEvolutions.add(rs.getString("a.name"));
            }
            return lstEvolutions;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean addPokemonByName(String name) {
        String sql = "insert into pokemon(name) values(?)";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean returnPokemonByName(String name) {
        String sql = "select name from pokemon where name ='"+name+"'";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ResultSet rs = null;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next())
            {
               return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean borrarPokemon(String name) {
        String sql = "delete from pokemon where name =?";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
   public boolean changePokemonName(String name, String newName) {
        String sql = "update pokemon p set p.name ='" + newName + "' where p.name='" + name +"'";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
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
        String sql = "select e.name, e.lvlEvolve from evolution e inner join evolution_pkm ep on e.id=ep.idEvo "
                + "inner join pokemon p on p.id=ep.idPkm where p.id=" + auxPokemon.getId();
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
                pokemon[1] = rs.getString("lvlEvolve");
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
    
    public Abilities createObjectAbilities(String name) {
        String sql = "select a.id, a.name from abilities a where a.name='"+name+"'"; 
        try {
            Abilities abi = new Abilities();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                abi.setId(rs.getInt("a.id"));
                abi.setName(rs.getString("a.name"));
                return abi;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Abilities getAuxAbi() {
        return auxAbi;
    }

    public void setAuxAbi(Abilities auxAbi) {
        this.auxAbi = auxAbi;
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

    public String addEvolution() {
        String sql = "insert into evolution(name,lvlEvolve) values(?,?)";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, controlador.getNewEvolution().getTxtEvo().getText());
            ps.setString(2, controlador.getNewEvolution().getTxtInputLvl().getText());
            ps.execute();
            String name=controlador.getNewEvolution().getTxtEvo().getText();
            controlador.getNewEvolution().getTxtEvo().setText(null);
            return name;
        } catch (Exception e) {
            System.out.println(e);
        }
        return ("Error");
    }
    
    public String addAbilitie() {
        String sql = "insert into abilities(name) values(?)";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, controlador.getNewAbilitie().getTxtNewAbilitie().getText());
            ps.execute();
            String name=controlador.getNewAbilitie().getTxtNewAbilitie().getText();
            controlador.getNewAbilitie().getTxtNewAbilitie().setText(null);
            return name;
        } catch (Exception e) {
            System.out.println(e);
        }
        return ("Error");
    }

    public String addAbilitieEvo() {
        String sql = "insert into abilities(name) values(?)";
        try {
            PreparedStatement ps = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, controlador.getNewAbilitieEvo().getTxtNewAbilitie().getText());
            ps.execute();
            String name = controlador.getNewAbilitieEvo().getTxtNewAbilitie().getText();
            controlador.getNewAbilitieEvo().getTxtNewAbilitie().setText(null);
            return name;
        } catch (Exception e) {
            System.out.println(e);
        }
        return ("Error");
    }

    public boolean removeAbilitie(int idPkm, int idAbilitie) {
        String sql = "delete from pokemon_abilities where idPkm=? and idAbilitie=?";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPkm);
            ps.setInt(2, idAbilitie);
            System.out.println(ps);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsInfo().getTableModifyAbilities());
            cargarTablaAbilities(controlador.getAllPokemonsInfo().getTableModifyAbilities());
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean removeAbilitieEvo(int idEvo, int idAbilitie) {
        String sql = "delete from evolution_abilities where idEvo=? and idAbilitie=?";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEvo);
            ps.setInt(2, idAbilitie);
            System.out.println(ps);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsModifyEvolution().getTableAbilitiesEvo());
            cargarTablaEvoAbilities(controlador.getAllPokemonsModifyEvolution().getTableAbilitiesEvo());
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addAbilitieToPokemon(int idAbilitie) {
        String sql = "insert into pokemon_abilities(idPkm,idAbilitie) values(?,?)";
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, auxPokemon.getId());
            ps.setInt(2, idAbilitie);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsInfo().getTableModifyAbilities());
            cargarTablaAbilities(controlador.getAllPokemonsInfo().getTableModifyAbilities());
            controlador.getNewAbilitie().getTxtNewAbilitie().setText(null);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int getIdFromAbilitieName(String name) {
        String sql = "select id from abilities where name='" + name + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next())
            {
             return(rs.getInt("id"));
            }     
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Evolution getAuxEvo() {
        return auxEvo;
    }

    public void setAuxEvo(Evolution auxEvo) {
        this.auxEvo = auxEvo;
    }

    public void btnTypes() {
        String sql = "select name from type";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                controlador.getAllPokemonsAddType().getTypeComboBox().addItem(rs.getString("name"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void btnTypesEvo() {
        String sql = "select name from type";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                controlador.getAllPokemonsAddTypeEvo().getTypeComboBox().addItem(rs.getString("name"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

     public int getIdFromTypeName(String name) {
        String sql = "select id from type where name='"+name+"'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next())
            {
             return (rs.getInt("id"));
            }     
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
  
    }

    public boolean addType(int id) {
        String sql = "insert into pokemon_type(idPkm,idType) values (?,?)";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, controlador.getModelo().getAuxPokemon().getId());
            ps.setInt(2, id);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsInfo().getTableModifyType());
            cargarTablaType(controlador.getAllPokemonsInfo().getTableModifyType());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean removeType(int id) {
        String sql = "delete from pokemon_type where idPkm=? and idType=?";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, controlador.getModelo().getAuxPokemon().getId());
            ps.setInt(2, id);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsInfo().getTableModifyType());
            cargarTablaType(controlador.getAllPokemonsInfo().getTableModifyType());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean removeTypeEvo(int id) {
        String sql = "delete from evolution_type where idEvo=? and idType=?";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, controlador.getModelo().getAuxEvo().getId());
            ps.setInt(2, id);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsModifyEvolution().getTableEvoType());
            cargarTablaEvoType(controlador.getAllPokemonsModifyEvolution().getTableEvoType());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean removeEvolution(int idevo, int idpkm) {
        String sql = "delete from evolution_pkm where idEvo=? and idPkm=?";
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idevo);
            ps.setInt(2, idpkm);
            System.out.println(ps);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsInfo().getTableModifyEvolution());
            cargarTablaEvolutions(controlador.getAllPokemonsInfo().getTableModifyEvolution());
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Type createTypeObject(String name) {
        String sql = "select t.id, t.name from type t where t.name='" + name + "'";
        try {
            Type ty = new Type();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ty.setId(rs.getInt("t.id"));
                ty.setName(rs.getString("t.name"));
                return ty;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean changePokemonName(int id) {
        String sql = "update pokemon p set p.name ='" + controlador.getAllPokemonsInfo().getTxtNewName().getText() + "' where p.id=" + id;
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            limpiarTabla(controlador.getAllPokemons().getTablaAllPkm());
            listAllPokemons(controlador.getAllPokemons().getTablaAllPkm());
            controlador.getAllPokemonsInfo().getLblNameModify().setText(controlador.getAllPokemonsInfo().getTxtNewName().getText());
            controlador.getAllPokemonsInfo().getTxtNewName().setText(null);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean changeEvolutionName(int id) {
        String sql = "update evolution e set e.name ='" + controlador.getAllPokemonsModifyEvolution().getTxtNewName().getText() + "' where e.id=" + id;
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
            controlador.getAllPokemonsModifyEvolution().getLblName().setText(controlador.getAllPokemonsModifyEvolution().getTxtNewName().getText());
            controlador.getAllPokemonsModifyEvolution().getTxtNewName().setText(null);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public int getIdFromEvolutionName(String name) {
        String sql = "select id from evolution where name='" + name + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next())
            {
             return(rs.getInt("id"));
            }     
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public boolean addEvolutionToPokemon(int idEvolution){
        String sql = "insert into evolution_pkm(idEvo,idPkm) values(?,?)";
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEvolution);
            ps.setInt(2, auxPokemon.getId());
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsInfo().getTableModifyEvolution());
            cargarTablaEvolutions(controlador.getAllPokemonsInfo().getTableModifyEvolution());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean removeDatabaseEvolution(int id) {
        String sql="delete from evolution where id="+id;
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps=con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
       return false;
    }
    
    public boolean removeDatabaseAbilitie(int id) {
        String sql="delete from abilities where id="+id;
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps=con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
       return false;
    }
    
    public boolean addTypeToEvolution(int idType) {
        String sql = "insert into evolution_type(idEvo,idType) values(?,?)";
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, auxEvo.getId());
            ps.setInt(2, idType);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsModifyEvolution().getTableEvoType());
            cargarTablaEvoType(controlador.getAllPokemonsModifyEvolution().getTableEvoType());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean addAbilitieToEvolution(int idAbilitie) {
        String sql = "insert into evolution_abilities(idEvo,idAbilitie) values(?,?)";
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, auxEvo.getId());
            ps.setInt(2, idAbilitie);
            ps.execute();
            limpiarTabla(controlador.getAllPokemonsModifyEvolution().getTableAbilitiesEvo());
            cargarTablaEvoAbilities(controlador.getAllPokemonsModifyEvolution().getTableAbilitiesEvo());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
