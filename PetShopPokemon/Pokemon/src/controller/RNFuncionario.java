/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.FuncionarioDao;

import view.TelaCadastroFuncionario;

/**
 *
 * @author Iuri
 */
public class RNFuncionario {
    private TelaCadastroFuncionario telaCadastroFuncionario;
    private Connection conexao;
    private FuncionarioDao funcDao;
    private boolean novo = true;
    private int id = 0;
    
    public RNFuncionario(TelaCadastroFuncionario tcf, Connection conexao){//tcp é a tela de cadastro de funcionarios
        this.conexao = conexao;
        this.funcDao = new FuncionarioDao(this.conexao);
        this.telaCadastroFuncionario = tcf;
        this.listar();
       /* this.gerenciarCampos();*/
        
    }
    
   
    // O metodo validaCampos verifica se os campos de nome, cargo, cpf, cel e Email estão vazios
    
    private boolean validacampos(){
        if(this.telaCadastroFuncionario.getjTextFieldNome().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroFuncionario.getjTextFieldCpf().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroFuncionario.getjComboBoxCargo().getSelectedIndex()==0){
            return false;
        }
        else if(this.telaCadastroFuncionario.getjTextFieldCel().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroFuncionario.getjTextFieldEmail().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroFuncionario.getjTextFieldLogin().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroFuncionario.getjTextFieldSenha().getText().equals("")){
            return false;
        }
        else{
            return true;
        }
    }
    
    // O metodo salvar verifica se todos os campos estão vazios com o metodo validaCamposse
    public void salvar(){
        if (validacampos()){
            Funcionario f = new Funcionario();
            f.setNomeFunc(this.telaCadastroFuncionario.getjTextFieldNome().getText());
            f.setCargo(this.telaCadastroFuncionario.getjComboBoxCargo().getSelectedItem().toString());
            f.setCpf(this.telaCadastroFuncionario.getjTextFieldCpf().getText());
            f.setCelular(this.telaCadastroFuncionario.getjTextFieldCel().getText());
            f.setEmail(this.telaCadastroFuncionario.getjTextFieldEmail().getText());
            f.setLogin(this.telaCadastroFuncionario.getjTextFieldLogin().getText());
            f.setSenha(this.telaCadastroFuncionario.getjTextFieldSenha().getText());
            
            if(this.novo == true){
                this.funcDao.inserir(f);
            }else{
                f.setId(id);
                this.funcDao.alterar(f);
            }
            this.limpar();
            listar();
            /*this.listar();*/
           /* this.gerenciarBotoes();
            this.gerenciarCampos();*/
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void novo(){
        this.novo = true;
        /*this.gerenciarBotoes();*/
        /*gerenciarCampos();*/
        limpar();
    }
    public void editar(){
        int item = this.telaCadastroFuncionario.getjTableFuncionario().getSelectedRow();
        
        if(item >= 0){
            this.id = (int)this.telaCadastroFuncionario.getModelo().getValueAt(item,0 );
            System.out.println(id);
            Funcionario f = funcDao.pesquisar(this.id);
            
            this.telaCadastroFuncionario.getjTextFieldNome().setText(f.getNomeFunc());
            this.telaCadastroFuncionario.getjComboBoxCargo().setSelectedItem(f.getCargo());
            this.telaCadastroFuncionario.getjTextFieldCpf().setText(f.getCpf());
            this.telaCadastroFuncionario.getjTextFieldCel().setText(f.getCelular());
            this.telaCadastroFuncionario.getjTextFieldEmail().setText(f.getEmail());
            this.telaCadastroFuncionario.getjTextFieldLogin().setText(f.getLogin());
            this.telaCadastroFuncionario.getjTextFieldSenha().setText(f.getSenha());
            this.novo = false;
            listar();
        }else{
            JOptionPane.showMessageDialog(this.telaCadastroFuncionario, "Selecione um item");
        }
    }
    //o  metodo novo seta como verdadeiro a variavel novo, seta os botoes e limpa os campos
    
    
    
    private void listar() {
        listaDados(funcDao.listar());
    }
    
    private void listaDados(ArrayList<Funcionario> listaFuncionario){
        limpaTabela();
        for(int i=0;i<listaFuncionario.size();i++){
            adicionaTabela(listaFuncionario.get(i).getId(),
                           listaFuncionario.get(i).getNomeFunc(),
                           listaFuncionario.get(i).getCargo(),
                           listaFuncionario.get(i).getCpf(),
                           listaFuncionario.get(i).getCelular(),
                           listaFuncionario.get(i).getEmail());
        }   
        
    }
    private void adicionaTabela(Object... objects){
        this.telaCadastroFuncionario.getModelo().addRow(objects);
    }
    
    void limpar() {
        this.telaCadastroFuncionario.limpar();
    }


    void pesquisar() {
        Funcionario f = new Funcionario();
        String nome = this.telaCadastroFuncionario.getjTextFieldNome().getText();
        
        f = funcDao.PesquisaNome(nome);
       /* System.out.println(f);*/
        /*funcDao.PesquisaNome(nome);*/
        if(f.getId() == 0){
            JOptionPane.showMessageDialog(null, "funcionario não existe");
        }else{
           mostraTabela(f);
        }
        
    }
    

    private void mostraTabela(Funcionario f) {
       
       ArrayList<Funcionario> listaDeFuncionario = new ArrayList<>();
       listaDeFuncionario.add(f); 
       listaDados(listaDeFuncionario);
    }   
    public void limpaTabela(){
        int linhas = this.telaCadastroFuncionario.getModelo().getRowCount();
        for(int i=0;i<linhas;i++){
            this.telaCadastroFuncionario.getModelo().removeRow(0);
        }
    }
    public void setarCampo(){
        int setar = this.telaCadastroFuncionario.getjTableFuncionario().getSelectedRow();
        this.telaCadastroFuncionario.getjTextFieldNome().setText(telaCadastroFuncionario.getjTableFuncionario().getModel().getValueAt(setar, 1).toString());
    }

    void deletar() {
        int item = this.telaCadastroFuncionario.getjTableFuncionario().getSelectedRow();
        if(item>=0){
            if(JOptionPane.showConfirmDialog(this.telaCadastroFuncionario, "Deseja realmente excluir?", "Confirmação de exclusão", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                Funcionario f = new Funcionario();
                f.setId((int)this.telaCadastroFuncionario.getModelo().getValueAt(item, 0));
                if(funcDao.excluir(f)){
                    this.telaCadastroFuncionario.getModelo().removeRow(item);                
                }
                limpar();
                listar();
            } 
        } else{
            JOptionPane.showMessageDialog(this.telaCadastroFuncionario, "Selecione um item");
        }
    }

    
    
}
