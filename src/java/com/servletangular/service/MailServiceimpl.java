/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletangular.service;

import com.servletangular.beans.Mail;
import com.servletangular.dao.MailDAO;
import com.servletangular.dao.MailDAOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class MailServiceimpl implements MailService{
    private MailDAOImpl maildao = new MailDAOImpl();
    
    @Override
    public List<Mail> findAll() {
        List<Mail> list = new ArrayList<>();
        try{
            list = maildao.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
       return list;
    }

    @Override
    public void save(String sql) {
       maildao.save(sql);
    }

    @Override
    public void delete(String sql) {
        maildao.delete(sql);
    }
    
}
