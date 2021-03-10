package controller;

import model.Pokemon;
import model.PokemonDao;
import view.TelaCadastroPokemon;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author André Luis
 */
public class RnPokemon {
    Connection link;
    TelaCadastroPokemon tela;
    PokemonDao  pokemonDao;
    Pokemon pokemon = new Pokemon();
    
    public RnPokemon(Connection link, TelaCadastroPokemon tela){
        this.tela = tela;
        this.link = link;
        pokemonDao = new PokemonDao();
        this.listar();
    }
    
    public void listar(){
        listarDados(pokemonDao.listar());
    }
    
    private void listarDados(ArrayList<Pokemon> lista){
        limparTabela();
        
        for (int i=0;i<lista.size();i++){
            adicionaNaTabela(lista.get(i).getNome(), lista.get(i).getEstoque(),
                    lista.get(i).getTipo1(), lista.get(i).getTipo2(),
                    lista.get(i).getHabilidade(), lista.get(i).getDescricao(),
                    lista.get(i).getPreco());
        }
    }
    
    private void adicionaNaTabela(Object ... object){
        this.tela.getModelo().addRow(object);
    }
    
    private void limparTabela(){
        int linhas = this.tela.getModelo().getRowCount();
        
        for(int i=0;i<linhas;i++){
            this.tela.getModelo().removeRow(0);
        }
    }
    
    public void pegar(){
        this.pokemon.setNome(this.tela.getjTextFieldNome().getText());
        this.pokemon.setEstoque(Integer.parseInt(this.tela.getjFormattedTextFieldQuantidade().getText()));
        this.pokemon.setPreco(Double.parseDouble(this.tela.getjFormattedTextFieldPreco().getText()));
        this.pokemon.setTipo1(this.tela.getjTextFieldTipo1().getText());
        this.pokemon.setTipo2(this.tela.getjTextFieldTipo2().getText());
        this.pokemon.setHabilidade(this.tela.getjTextFieldHabilidade().getText());
        this.pokemon.setDescricao(this.tela.getjTextAreaDescricao().getText());
    }
    
    private void mostrar(Pokemon pokemon){
        this.tela.setjTextFieldNome(pokemon.getNome());
        this.tela.setjFormattedTextFieldQuantidade(pokemon.getEstoque());
        this.tela.setjFormattedTextFieldPreco(pokemon.getPreco());
        this.tela.setjTextFieldTipo1(pokemon.getTipo1());
        this.tela.setjTextFieldTipo2(pokemon.getTipo2());
        this.tela.setjTextFieldHabilidade(pokemon.getHabilidade());
        this.tela.setjTextAreaDescricao(pokemon.getDescricao());
    }
    
    public void cadastrar(){
        pegar();
        if(pokemon.getNome().isEmpty() ||  pokemon.getTipo1().isEmpty()){
            JOptionPane.showMessageDialog(null, "Os campos(Nome/Tipo1) não podem ficar vazios.");
        } else {
            pokemonDao.cadastrar(pokemon);
            listar();
        }
    }
    
    public void editar(){
        pegar();
        if(pokemon.getNome().isEmpty() ||  pokemon.getTipo1().isEmpty()){
            JOptionPane.showMessageDialog(null, "Os campos(Nome/Tipo1) não podem ficar vazios.");
        } else {
            pokemonDao.editar(pokemon);
            listar();
        }
    }
    
    public void buscar(){
        String nome = this.tela.getjTextFieldBusca().getText();
        
        this.pokemon = pokemonDao.pesquisar(nome);
        
        mostrar(pokemon);
    }
    
    public void deletar(){
        int row = this.tela.getjTableResultados().getSelectedRow();
        
        if(row >= 0){
            String pokemon;

            pokemon = this.tela.getModelo().getValueAt(row, 0).toString();

            pokemonDao.deletar(pokemon);

            this.listar();
        }
        else{
            JOptionPane.showMessageDialog(null, "Nenhum pokemon selecionado.");
        }
    }
}


