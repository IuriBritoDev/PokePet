package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaPrincipal;

/**
 * @author Iuri
 */
public class ControlePrincipal implements ActionListener{
    
    private TelaPrincipal telaPrincipal;
    private ControleVenda controleVenda;
    private ControleProduto controleProduto;
    private ControleFuncionario controleFuncionario;
    private ControleEstoque controleEstoque;
    private ControleCadastroPokemon controleCadastroPokemon;
    private Connection conexao;
    
    public ControlePrincipal(){
       this.conexao = Conexao.getConexao();
       this.telaPrincipal = new TelaPrincipal();
       this.telaPrincipal.getjMenuVenda().addActionListener(this);
       this.telaPrincipal.getjMenuProduto().addActionListener(this);
       this.telaPrincipal.getjMenuFuncionario().addActionListener(this);
       this.telaPrincipal.getjMenuEstoque().addActionListener(this);
       this.telaPrincipal.getjMenuCadastroPokemon().addActionListener(this);
       //this.telaPrincipal.getjMenuItemPessoa().addActionListener(this);       
       this.telaPrincipal.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource() == telaPrincipal.getjMenuVenda() ||
                evento.getSource() == telaPrincipal.getjMenuVenda()){
            this.controleVenda = new ControleVenda(telaPrincipal);
        }
        if(evento.getSource() == telaPrincipal.getjMenuProduto() ||
                evento.getSource() == telaPrincipal.getjMenuProduto()){
            this.controleProduto = new ControleProduto(telaPrincipal);
        }
        if(evento.getSource() == telaPrincipal.getjMenuFuncionario() ||
                evento.getSource() == telaPrincipal.getjMenuFuncionario()){
            this.controleFuncionario = new ControleFuncionario(telaPrincipal,conexao);
        }
        if(evento.getSource() == telaPrincipal.getjMenuEstoque() ||
                evento.getSource() == telaPrincipal.getjMenuEstoque()){
            this.controleEstoque = new ControleEstoque(telaPrincipal);
        }
        if(evento.getSource() == telaPrincipal.getjMenuCadastroPokemon() ||
                evento.getSource() == telaPrincipal.getjMenuCadastroPokemon()){
            this.controleCadastroPokemon = new ControleCadastroPokemon(telaPrincipal);
        }    
    }

}
