/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juven
 */
public class ConexaoBD {
    
    public static Connection conectar(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/trabalho1";
        String user = "teste";
        String password = "teste";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar no banco: " + ex.getMessage());
        }
        catch (ClassNotFoundException ex){  
            System.out.println("Erro ao carregar o Driver: " + ex.getMessage());  
        } 

        return con;                
    }  
    
    public static void main(String[] args) {
        Connection con = ConexaoBD.conectar();
        System.out.println("Conexão: " + con);
    }
}
