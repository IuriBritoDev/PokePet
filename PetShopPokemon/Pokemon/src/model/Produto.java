package model;

/**
 *
 * @author Iuri
 */
public class Produto {
    
    private String nomeProd;
    private float preco;
    private int quantidadeProd;
    private String destricao;

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidadeProd() {
        return quantidadeProd;
    }

    public void setQuantidadeProd(int quantidadeProd) {
        this.quantidadeProd = quantidadeProd;
    }

    public String getDestricao() {
        return destricao;
    }

    public void setDestricao(String destricao) {
        this.destricao = destricao;
    }
    

}
