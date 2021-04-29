/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author juven
 */
public class Produto {

    private int idproduto;
    private String descricao;
    private float preco;
    private float estoque;
    private String observacao;
    private int idcategoria;

    public Produto(String descricao, float preco, float estoque, String observacao, int idcategoria) {
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.observacao = observacao;
        this.idcategoria = idcategoria;
    }

    public Produto(int idproduto, String descricao, float preco, float estoque, String observacao, int idcategoria) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.observacao = observacao;
        this.idcategoria = idcategoria;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
}
