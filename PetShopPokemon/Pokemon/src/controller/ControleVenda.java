package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaVenda;
import view.TelaPrincipal;

/**
 *
 * @author Iuri
 */
public class ControleVenda implements ActionListener{
    private TelaVenda telaVenda;
    private RNVenda rNproduto;
    private Connection conexao;

    public ControleVenda(TelaPrincipal telaPrincipal) {
        this.conexao = Conexao.getConexao();
        this.telaVenda = new TelaVenda(telaPrincipal,true);
        //this.rNproduto - new RNProduto(telaVenda);
        this.telaVenda.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
