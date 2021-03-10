package controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Conexao;
import view.TelaVenda;
/**
 *
 * @author Iuri
 */
public class RNVenda {
    
    private TelaVenda telaVenda;
    
    private Connection conexao;

    public RNVenda(TelaVenda telaVenda) {
        this.conexao = Conexao.getConexao();
        this.telaVenda = telaVenda;
    }
    
    

}
