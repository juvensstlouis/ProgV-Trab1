/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CategoriaDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import models.Categoria;

/**
 *
 * @author juven
 */
@ManagedBean
@ViewScoped
public class BeanCategoria implements Serializable {

    private int idcategoria;
    private String descricao;

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<Categoria> consultarTudo() {
        return CategoriaDAO.consultarTudo();
    }
    
    public String consultarNome(int idcategoria) {
        return CategoriaDAO.consultarNome(idcategoria);
    }
}
