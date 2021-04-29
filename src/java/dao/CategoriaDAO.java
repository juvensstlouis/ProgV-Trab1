/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.utils.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Categoria;
import models.Produto;

/**
 *
 * @author juven
 */
public class CategoriaDAO {

    public static List<Categoria> consultarTudo() {
        List<Categoria> lista = new ArrayList<>();
        try {
            String sql = "select * from categoria";

            Connection con = ConexaoBD.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
              lista.add(new Categoria(
                      rs.getInt("idcategoria"),
                      rs.getString("descricao")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
        return lista;
    }

    public static String consultarNome(int idcategoria) {
        try {
            String sql = "select descricao from categoria where idcategoria = " + idcategoria;
            Connection con = ConexaoBD.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return rs.getString("descricao");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return "";
    }
}
