/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletangular.controller;

import com.google.gson.Gson;
import com.servletangular.beans.Mail;
import com.servletangular.dao.util.ConnectionUtil;
import com.servletangular.service.MailService;
import com.servletangular.service.MailServiceimpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author HP
 */
//@WebServlet("/Mailservlet")
public class Mailservlet extends HttpServlet {
    private MailServiceimpl mailservice;

    @Override
    public void init() throws ServletException {
        super.init();
        mailservice = new MailServiceimpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mail>mails = mailservice.findAll();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        Gson gson = new Gson();
      
        if(mails.size()>0){
           String jsondata = gson.toJson(mails);
           out.print(jsondata);
        }
        out.close();
        
        //response.setContentType("text/html;charset=UTF-8");
        /**try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<!DOCTYPE html>");
            //out.println("<html>");
            //out.println("<head>");
            //out.println("<title>Servlet NewServlet</title>");            
            //out.println("</head>");
            //out.println("<body>");
            //out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            //out.println("</body>");
            //out.println("</html>");
        //}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONParser parser = new JSONParser();
        JSONObject jObj = null;
        try {
            jObj = (JSONObject) parser.parse(sb.toString());
        } catch (ParseException ex) {
            Logger.getLogger(Mailservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int id = Integer.valueOf(jObj.get("mailid").toString());
        String expediteur = jObj.get("expediteur").toString();
        String destinataire = jObj.get("destinataire").toString();
        String objet = jObj.get("objet").toString();
        String sujet = jObj.get("sujet").toString();
        
        
        mailservice.save("INSERT INTO `user`(`id`, `expediteur`, `destinataire`,`objet`,`sujet`) VALUES ('"+id+"','"+expediteur+"','"+destinataire+"','"+objet+"','"+sujet+"')");
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONParser parser = new JSONParser();
        JSONObject jObj = null;
        try {
            jObj = (JSONObject) parser.parse(sb.toString());
        } catch (ParseException ex) {
            Logger.getLogger(Mailservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String expediteur = jObj.get("expediteur").toString();
        
        
        mailservice.delete("DELETE FROM user WHERE expediteur = '"+expediteur+"'");
    }
    
}
