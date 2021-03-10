/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class PokemonDao {
    
    public Connection conexao;
    Pokemon pokemon;
    
    public PokemonDao(){
        this.conexao = Conexao.getConexao();
    }
    
    public Pokemon pesquisar(String nome){
        this.pokemon = new Pokemon();
        
        String sql = "select * from tb_pokemon where nome like ?";
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            
            rs = pst.executeQuery();
            while(rs.next()){
                this.pokemon.setNome(rs.getString("Nome"));
                this.pokemon.setPreco(rs.getFloat("Preco"));
                this.pokemon.setEstoque(rs.getInt("Estoque"));
                this.pokemon.setTipo1(rs.getString("Tipo"));
                this.pokemon.setTipo2(rs.getString("Tipo2"));
                //this.pokemon.setEvolucao(rs.getInt("Evolucao"));
                //this.pokemon.setdEvolucao(rs.getInt("dEvolucao"));
                this.pokemon.setHabilidade(rs.getString("Habilidade"));
                this.pokemon.setDescricao(rs.getString("Descricao"));
            }
            pst.close();
            rs.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel pesquisar!");
            System.out.println(ex);
        }
        
        
        return this.pokemon;
    }
    
    public boolean buscar(Pokemon pokemon){
        this.pokemon = new Pokemon();
        
        String sql = "select * from tb_pokemon where nome like ?";
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, pokemon.getNome());
            
            rs = pst.executeQuery();
            while(rs.next()){
                this.pokemon.setId(rs.getInt("Id"));
            }
            pst.close();
            rs.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar!");
            System.out.println(ex);
        }
        
        
        return this.pokemon.getId() > 0;
    }
    
    
    public void deletar(String pokemon){
        
        int resposta = JOptionPane.showConfirmDialog(null, "Deletar pokemon?");
        
        if(resposta == JOptionPane.YES_OPTION){
            System.out.println(pokemon);
            String sql = "delete from tb_pokemon where nome like ?";
            PreparedStatement pst;

            try{
                pst = conexao.prepareStatement(sql);
                pst.setString(1, pokemon);

                pst.execute();          
                JOptionPane.showMessageDialog(null, "Pokemon deletado com sucesso!");
                pst.close();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possivel deletar!");
                System.out.println(ex);
            }
        }
        
        
    }

    public void cadastrar(Pokemon pokemon){
        
        if(!buscar(pokemon)){
            String sql = "insert into tb_pokemon value(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;

            try{
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, pokemon.getId());
                pst.setString(2, pokemon.getNome());
                pst.setDouble(3, pokemon.getPreco());
                pst.setInt(4, pokemon.getEstoque());
                pst.setString(5, pokemon.getTipo1());
                pst.setString(6, pokemon.getTipo2());
                //pst.setInt(7, pokemon.getEvolucao());
                //pst.setInt(8, pokemon.getdEvolucao());
                pst.setString(7, pokemon.getHabilidade());
                pst.setString(8, pokemon.getDescricao());

                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Pokémon cadastrado com sucesso!");
                pst.close();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
                System.out.println(ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar, pokemon ja existe!");
        }
    }
    
    public void editar(Pokemon pokemon){
        
        if(buscar(pokemon)){
            
            String sql = "update tb_pokemon set preco = ?, estoque = ?, tipo = ?, tipo2 = ?, habilidade = ?, descricao = ? where nome = ?";
            PreparedStatement pst;

            try{
                pst = conexao.prepareStatement(sql);
                pst.setDouble(1, pokemon.getPreco());
                pst.setInt(2, pokemon.getEstoque());
                pst.setString(3, pokemon.getTipo1());
                pst.setString(4, pokemon.getTipo2());
                //pst.setInt(7, pokemon.getEvolucao());
                //pst.setInt(8, pokemon.getdEvolucao());
                pst.setString(5, pokemon.getHabilidade());
                pst.setString(6, pokemon.getDescricao());
                pst.setString(7, pokemon.getNome());

                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Pokémon editado com sucesso!");
                pst.close();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possível editar!");
                System.out.println(ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Não foi possível editar, pokemon não existe!");
        }
    }
    
    public ArrayList<Pokemon> listar(){
        ArrayList<Pokemon> lista = new ArrayList<>();
        
        String sql = "select * from tb_pokemon";
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = conexao.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                this.pokemon = new Pokemon();
                
                this.pokemon.setId(rs.getInt("Id"));
                this.pokemon.setNome(rs.getString("Nome"));
                this.pokemon.setPreco(rs.getFloat("Preco"));
                this.pokemon.setEstoque(rs.getInt("Estoque"));
                this.pokemon.setTipo1(rs.getString("Tipo"));
                this.pokemon.setTipo2(rs.getString("Tipo2"));
                this.pokemon.setHabilidade(rs.getString("Habilidade"));
                this.pokemon.setDescricao(rs.getString("Descricao"));
                //this.pokemon.setEvolucao(rs.getInt("Evolucao"));
                //this.pokemon.setdEvolucao(rs.getInt("dEvolucao"));
                lista.add(this.pokemon);
            }
            pst.close();
            rs.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel listar!");
            System.out.println(ex);
        }
        
        return lista;
    }
    
}

