package controller;

import javax.swing.JOptionPane;
import model.LoginDao;
import model.Usuario;
import view.TelaLogin;

/**
 * @author Iuri
 */
public class RNLogin {

    private TelaLogin telalogin;
    private LoginDao logindao;

    public RNLogin(TelaLogin login) {
        this.telalogin = login;
        this.logindao = new LoginDao();
    }
 
    public void acesso(){
        Usuario usuario = new Usuario();
        usuario.setLogin(this.telalogin.gettxtUsuario().getText());
        usuario.setSenha(this.telalogin.gettxtSenha().getText());
        
        if(this.logindao.acesso(usuario).getId() > 0){
            this.telalogin.dispose();
            ControlePrincipal cp = new ControlePrincipal();
        }else{
            JOptionPane.showMessageDialog(telalogin,"acesso negado");
        }
            
    }

}
