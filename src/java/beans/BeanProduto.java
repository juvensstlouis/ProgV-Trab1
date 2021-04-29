/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProdutoDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.Produto;

/**
 *
 * @author juven
 */
@ManagedBean
@ViewScoped
public class BeanProduto implements Serializable {

    private int idproduto;
    private String descricao;
    private float preco;
    private float estoque;
    private String observacao;
    private int idcategoria;

    private String filtro = "";
    private boolean isFiltrarCategoria;
    private List<Produto> lista;

    public void carregarCampos() {
        if (idproduto > 0) {
            Produto p = ProdutoDAO.consultarPorId(idproduto);
            descricao = p.getDescricao();
            preco = p.getPreco();
            estoque = p.getEstoque();
            observacao = p.getObservacao();
            idcategoria = p.getIdcategoria();
        }
    }

    public String salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (descricao.equals("")) {
            msg = new FacesMessage("Informe a descrição");
            view.addMessage(null, msg);
        }

        if (idcategoria == 0) {
            msg = new FacesMessage("Selecione a categoria");
            view.addMessage(null, msg);
        }

        if (preco == 0) {
            msg = new FacesMessage("Informe o preço");
            view.addMessage(null, msg);
        }

        if (estoque == 0) {
            msg = new FacesMessage("Informe a quantidade em estoque");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            Produto p = new Produto(descricao, preco, estoque, observacao, idcategoria);

            if (idproduto == 0) {
                ProdutoDAO.salvar(p);
            } else {
                p.setIdproduto(idproduto);
                ProdutoDAO.update(p);
            }

            return "consultaprodutos?faces-redirect=true";
        }

        return "";
    }

    public void pesquisar() {
        if (isFiltrarCategoria && idcategoria > 0) {
            lista = ProdutoDAO.consultarPorNomeECategoria(filtro, idcategoria);
        } else {
            lista = ProdutoDAO.consultarPorNome(filtro);
            System.out.println("Filtro: " + filtro);
        }
    }

    public String redirecionarParaAtualizar(int idproduto) {
        return "cadastraproduto?faces-redirect=true&idproduto=" + idproduto;
    }

    public void deletar(int idproduto) {
        ProdutoDAO.deletarPorId(idproduto);
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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public boolean isIsFiltrarCategoria() {
        return isFiltrarCategoria;
    }

    public void setIsFiltrarCategoria(boolean isFiltrarCategoria) {
        this.isFiltrarCategoria = isFiltrarCategoria;
    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }
}
