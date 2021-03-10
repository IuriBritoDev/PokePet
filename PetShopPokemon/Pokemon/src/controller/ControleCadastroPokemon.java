package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.Conexao;
import view.TelaCadastroPokemon;
import view.TelaPrincipal;
/**
 *
 * @author André Luis
 */
public class ControleCadastroPokemon implements ActionListener{
    
    TelaCadastroPokemon cadastroPokemon ;
    Connection link;
    RnPokemon rnPokemon;

    ControleCadastroPokemon(TelaPrincipal telaPrincipal) {
        this.link = Conexao.getConexao();
        this.cadastroPokemon = new TelaCadastroPokemon(telaPrincipal,true);
       
        rnPokemon = new RnPokemon(link, cadastroPokemon);
        
        this.cadastroPokemon.getjButtonCadastrar().addActionListener(this);
        this.cadastroPokemon.getjButtonBuscar().addActionListener(this);
        this.cadastroPokemon.getjButtonDeletar().addActionListener(this);
        this.cadastroPokemon.getjButtonEditar().addActionListener(this);
        this.cadastroPokemon.setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(this.cadastroPokemon.getjButtonCadastrar() == e.getSource()){
            cadastrar();
        }
        
        if(this.cadastroPokemon.getjButtonBuscar() == e.getSource()){
            buscar();
        }
        
        if(this.cadastroPokemon.getjButtonDeletar()== e.getSource()){
            deletar();
        }
        
        if(this.cadastroPokemon.getjButtonEditar()== e.getSource()){
            editar();
        }
    }
    
    private void cadastrar(){
        rnPokemon.cadastrar();
    }
    
    private void buscar(){
        rnPokemon.buscar();
    }
    
    private void deletar(){
        rnPokemon.deletar();
    }
    
    private void editar(){
        rnPokemon.editar();
    }
}
