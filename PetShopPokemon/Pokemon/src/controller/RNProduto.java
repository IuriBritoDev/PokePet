/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import model.Conexao;
import view.TelaCadastroProduto;
/**
 *
 * @author Iuri
 */
public class RNProduto {
    
    private TelaCadastroProduto telaCadastroProduto;
    
    private Connection conexao;

    public RNProduto(TelaCadastroProduto telaCadastroProduto) {
        this.conexao = Conexao.getConexao();
        this.telaCadastroProduto = telaCadastroProduto;
    }
    
    

}
