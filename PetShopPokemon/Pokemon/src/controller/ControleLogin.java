package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaLogin;

/**
 * @author Iuri
 */
public class ControleLogin implements ActionListener{
    
    private TelaLogin telalogin;
    private RNLogin rnlogin;
    
    public Connection conexao;

    public ControleLogin() {
        this.conexao = Conexao.getConexao();
        this.telalogin = new TelaLogin(null,true);
        this.telalogin.getbtnLogin().addActionListener(this);
        this.rnlogin = new RNLogin(telalogin);
        this.telalogin.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource() == telalogin.getbtnLogin()){
            acesso();
        }
    }
    
    public void acesso(){
        this.rnlogin.acesso();
    }

}
