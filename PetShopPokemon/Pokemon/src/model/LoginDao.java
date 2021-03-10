package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 * @author Iuri
 */
public class LoginDao {
    
    public Connection conexao;
    
    public LoginDao(){
        this.conexao = Conexao.getConexao();
    }
    
    public Usuario acesso(Usuario usuario){
        
        String sql = "select * from tb_funcionario where Login like ? and Senha like ?";
        Usuario user = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            
            rs = pst.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("IdFunc"));
                user.setLogin(rs.getString("Login"));
                user.setSenha(rs.getString("Senha"));
            }
            pst.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível buscar!");
            System.out.println(e);
        }
        
        return user;
    }

}
