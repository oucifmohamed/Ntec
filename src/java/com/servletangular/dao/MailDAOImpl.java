/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletangular.dao;

import com.servletangular.beans.Mail;
import com.servletangular.dao.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class MailDAOImpl implements MailDAO{

    @Override
    public List<Mail> findAll() throws SQLException{
        
       List<Mail>mails = new ArrayList<Mail>();
       ConnectionUtil connection = new ConnectionUtil();
       Connection con = connection.getConnection();
       PreparedStatement pr = con.prepareStatement(SQLQuery.SQL_SELECT);
       ResultSet rs = pr.executeQuery();
       while(rs.next()){
           int mailid = rs.getInt(1);
           String ex = rs.getString(2);
           String des = rs.getString(3);
           String ob = rs.getString(4);
           String su = rs.getString(5);
           Mail mail = new Mail(mailid,ex,des,ob,su);
           mails.add(mail);
       }
       return mails;
    }

    @Override
    public void save(String sql){
        ConnectionUtil connection = new ConnectionUtil();
       Connection con = connection.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String sql) {
       ConnectionUtil connection = new ConnectionUtil();
       Connection con = connection.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    
}
