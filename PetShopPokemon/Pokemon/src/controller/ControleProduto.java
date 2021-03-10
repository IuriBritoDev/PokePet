/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaCadastroProduto;
import view.TelaPrincipal;

/**
 *
 * @author Iuri
 */
public class ControleProduto implements ActionListener{
    
    private TelaCadastroProduto telaCadastroProduto;
    private Connection conexao;

    public ControleProduto(TelaPrincipal telaPrincipal) {
        this.conexao = Conexao.getConexao();
        this.telaCadastroProduto = new TelaCadastroProduto(telaPrincipal,true);
        this.telaCadastroProduto.setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
