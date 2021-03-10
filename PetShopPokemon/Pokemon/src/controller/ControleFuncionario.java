package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaCadastroFuncionario;
import view.TelaPrincipal;

/**
 *
 * @author Iuri
 */
public class ControleFuncionario implements ActionListener{
    private TelaCadastroFuncionario telaCadastroFuncionario;
    private Connection conexao;
    private RNFuncionario rnFuncionario;
    

    ControleFuncionario(TelaPrincipal telaPrincipal, Connection conexao) {
        this.telaCadastroFuncionario = new TelaCadastroFuncionario(telaPrincipal,true);
        this.telaCadastroFuncionario.getjButtonEnviar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonEditar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonPesquisar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonExcluir().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonLimpar().addActionListener(this);
        
        this.conexao = conexao;
        this.rnFuncionario = new RNFuncionario(this.telaCadastroFuncionario,this.conexao);
        this.telaCadastroFuncionario.setVisible(true);
        
    }

    ControleFuncionario(TelaPrincipal telaPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaCadastroFuncionario.getjButtonExcluir()){    
            deletar();
        }
        if(evento.getSource() == this.telaCadastroFuncionario.getjButtonEnviar()){    
            salvar();
        }
        if(evento.getSource() == this.telaCadastroFuncionario.getjButtonEditar()){
            editar();
        }
        if(evento.getSource() == this.telaCadastroFuncionario.getjButtonPesquisar()){
            pesquisar();
            
        }
        if(evento.getSource() == this.telaCadastroFuncionario.getjButtonLimpar()){
            limpar();
            
        }
        

    }

    private void limpar() {
        this.rnFuncionario.limpar();
    }
    private void salvar() {
        this.rnFuncionario.salvar();
    }
    private void editar() {
        this.rnFuncionario.editar();
    }

    private void pesquisar() {
        this.rnFuncionario.pesquisar();
    }

    private void deletar() {
        this.rnFuncionario.deletar();
    }
    
    

}
