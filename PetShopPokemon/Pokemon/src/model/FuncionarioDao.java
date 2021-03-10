/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.TelaCadastroFuncionario;


/**
 *
 * @author Iuri
 */
public class FuncionarioDao {
    private final Connection conexao;
    private TelaCadastroFuncionario telaCadastroFuncionario;

    public FuncionarioDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Funcionario funcionario) {
        if(!buscar(funcionario)){
            String sql = "insert into tb_funcionario(Nome, Cpf, Cargo, Celular, Email, Login, Senha) value (?,?,?,?,?,?,?)";
            
            PreparedStatement pst;
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,funcionario.getNomeFunc());
                pst.setString(2,funcionario.getCpf());
                pst.setString(3,funcionario.getCargo());
                pst.setString(4,funcionario.getCelular());
                pst.setString(5,funcionario.getEmail());
                pst.setString(6,funcionario.getLogin());
                pst.setString(7,funcionario.getSenha());
                pst.execute();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel inserir.");
                System.out.println(ex);
               
            }
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso.");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir. Pessoa já cadastrada.");
        }
    }
    private boolean buscar(Funcionario funcionario){
        
        String sql = "select * from tb_funcionario where cpf like ?";
        Funcionario f = new Funcionario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, funcionario.getCpf());
            rs = pst.executeQuery();
            while(rs.next()){
                f.setId(rs.getInt("idFunc"));
                f.setNomeFunc(rs.getString("Nome"));
                f.setCpf(rs.getString("cpf"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscarrrrrrrrrrrrr.");
            System.out.println(ex);
        }
        
        return(f.getId()>0);
        
    
    }
    public Funcionario pesquisar(int id){
        String sql = "select * from tb_funcionario where idFunc = ?";
        Funcionario f = new Funcionario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                f.setId(rs.getInt("idFunc"));
                f.setNomeFunc(rs.getString("Nome"));
                f.setCpf(rs.getString("Cpf"));
                f.setCargo(rs.getString("Cargo"));
                f.setCelular(rs.getString("Celular"));
                f.setEmail(rs.getString("Email"));
                f.setLogin(rs.getString("Login"));
                f.setSenha(rs.getString("Senha"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel pesquisar.");
            System.out.println(ex);
        }
        return f;
    }
    public Funcionario PesquisaNome(String nome){
        String sql = "select * from tb_funcionario where  Nome like ?";
        Funcionario f = new Funcionario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,nome + "%");
            rs = pst.executeQuery();
            while(rs.next()){
                f.setId(rs.getInt("idFunc"));
                f.setNomeFunc(rs.getString("Nome"));
                f.setCpf(rs.getString("Cpf"));
                f.setCargo(rs.getString("Cargo"));
                f.setCelular(rs.getString("Celular"));
                f.setEmail(rs.getString("Email"));
                f.setLogin(rs.getString("Login"));
                f.setSenha(rs.getString("Senha"));
                System.out.println("funcionario pesquisado");
                System.out.println(rs);
            }
            System.out.println(f);
            
                    /*jTableFuncionario.setModel(DbUtils.resultSetToTableModel(rs));*/
            
            /*System.out.println(rs);*/
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar.");
            System.out.println(ex);
        }
        
        return f;
        
    }
    public ArrayList<Funcionario> listar(){
        String sql = "select * from tb_funcionario order by Nome,Cpf";
        
        ArrayList<Funcionario> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("idFunc"));
                funcionario.setNomeFunc(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setEmail(rs.getString("Email"));
                lista.add(funcionario);
            }
            rs.close();
            pst.close();
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel listar.");
            System.out.println(ex);
        }
        return lista;
        
    }
    
    public boolean excluir(Funcionario funcionario) {
        
        String sql = "delete from tb_funcionario where idFunc = ?";
        boolean result = false;
                
        if(!buscar(funcionario)){
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setInt(1, funcionario.getId());
                result = pst.execute();
                pst.close();                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir.");
                System.out.println(ex);
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Pessoa não cadastrada.");
        }
        
        return result;     
        
    }
    public void alterar(Funcionario funcionario) {
        String sql = "update tb_funcionario set Nome = ? , Cpf = ?, Cargo = ?, Celular = ?, Email = ?, Login = ?, Senha = ? where idFunc = ?";

        if(buscar(funcionario)){
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setString(1,funcionario.getNomeFunc());
                pst.setString(2,funcionario.getCpf());
                pst.setString(3,funcionario.getCargo());
                pst.setString(4,funcionario.getCelular());
                pst.setString(5,funcionario.getEmail());
                pst.setString(6,funcionario.getLogin());
                pst.setString(7,funcionario.getSenha());
                pst.setInt(8,funcionario.getId());
                pst.execute();
                pst.close();                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel alterar.");
                System.out.println(ex);
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Pessoa não cadastrada.");
        } 
    }

    
}
