/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletangular.dao;

import com.servletangular.beans.Mail;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface MailDAO {
    public List<Mail> findAll() throws SQLException;
    public void save(String sql);
    public void delete(String sql);
}
