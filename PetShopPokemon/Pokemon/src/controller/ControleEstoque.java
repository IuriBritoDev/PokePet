package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaAdocao;
import view.TelaPrincipal;
/**
 *
 * @author Iuri
 */
public class ControleEstoque {
    
    private TelaAdocao telaEstoque;
    private Connection conexao;

    ControleEstoque(TelaPrincipal telaPrincipal) {
        this.conexao = Conexao.getConexao();
        this.telaEstoque = new TelaAdocao(telaPrincipal,true);
        this.telaEstoque.setVisible(true);
    }

}
