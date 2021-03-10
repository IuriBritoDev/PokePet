/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Iuri
 */
public class Pokemon {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    private String tipo1;
    private String tipo2;
    //private int evolucao;
    //private int dEvolucao;
    private String Habilidade;
    private String descricao;

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    /*public int getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(int evolucao) {
        this.evolucao = evolucao;
    }

    public int getdEvolucao() {
        return dEvolucao;
    }

    public void setdEvolucao(int dEvolucao) {
        this.dEvolucao = dEvolucao;
    }*/

    public String getHabilidade() {
        return Habilidade;
    }

    public void setHabilidade(String Habilidade) {
        this.Habilidade = Habilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

}
