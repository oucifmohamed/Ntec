/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletangular.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ConnectionUtil {
 private Connection conn;
    private Statement st;
    public Connection getConnection(){
        
        try{
            String url = "jdbc:mysql://localhost:3306/formhtml";
            String user = "root";
            String pass = "pirati3a9li";
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch(SQLException ex){
            System.out.println("Error"+ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            System.out.println("Error"+ex.getMessage());
        }
        finally{
            return conn;
        }
    } 
}
