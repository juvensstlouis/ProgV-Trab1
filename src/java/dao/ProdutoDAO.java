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
import models.Produto;

/**
 *
 * @author juven
 */
public class ProdutoDAO {

    public static void salvar(Produto p) {
        try {
            String sql = "insert into produto(descricao, preco, estoque, observacao, idcategoria) "
                    + "values(?,?,?,?,?);";

            Connection con = ConexaoBD.conectar();

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, p.getDescricao());
            stm.setFloat(2, p.getPreco());
            stm.setFloat(3, p.getEstoque());
            stm.setString(4, p.getObservacao());
            stm.setInt(5, p.getIdcategoria());

            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public static Produto consultarPorId(int idproduto) {
        try {
            String sql = "select * from produto where idproduto = " + idproduto;
            Connection con = ConexaoBD.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new Produto(rs.getInt("idproduto"),
                                    rs.getString("descricao"),
                                    rs.getFloat("preco"),
                                    rs.getFloat("estoque"),
                                    rs.getString("observacao"),
                                    rs.getInt("idcategoria"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
        return null;
    }

    public static List<Produto> consultarPorNome(String nome) {
        List<Produto> lista = new ArrayList<>();
        try {
            String sql = "select * from produto where descricao like '%" + nome + "%'";

            Connection con = ConexaoBD.conectar();

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                lista.add(new Produto(
                        rs.getInt("idproduto"),
                        rs.getString("descricao"),
                        rs.getFloat("preco"),
                        rs.getFloat("estoque"),
                        rs.getString("observacao"),
                        rs.getInt("idcategoria")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return lista;
    }

    public static List<Produto> consultarPorNomeECategoria(String nome, int idcategoria) {
        List<Produto> lista = new ArrayList<>();
        try {
            String sql = "select * from produto"
                    + " where descricao like '%" + nome + "%'"
                    + " and idcategoria = " + idcategoria;

            Connection con = ConexaoBD.conectar();

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                lista.add(new Produto(
                        rs.getInt("idproduto"),
                        rs.getString("descricao"),
                        rs.getFloat("preco"),
                        rs.getFloat("estoque"),
                        rs.getString("observacao"),
                        rs.getInt("idcategoria")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return lista;
    }
    
    public static void update(Produto p) {
        try {
            String sql = "update produto" 
                      + " set descricao = ?"
                    + ", preco = ?" 
                    + ", estoque = ?"
                    + ", observacao = ?"
                    + ", idcategoria = ? " 
                    + "where idproduto = ?";
            
            Connection con = ConexaoBD.conectar();

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, p.getDescricao());
            stm.setFloat(2, p.getPreco());
            stm.setFloat(3, p.getEstoque());
            stm.setString(4, p.getObservacao());
            stm.setInt(5, p.getIdcategoria());
            stm.setInt(6, p.getIdproduto());

            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static void deletarPorId(int idproduto) {
        try {
            String sql = "delete from produto where idproduto = " + idproduto;
            Connection con = ConexaoBD.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
