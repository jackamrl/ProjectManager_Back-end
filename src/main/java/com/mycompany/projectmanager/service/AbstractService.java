/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.service;

/**
 *
 * @author Administrateur
 */
import com.mycompany.projectmanager.dao.UserDAO;
import com.mycompany.projectmanager.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    protected final  Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected UserDAO userDAO;
    protected final String USER_INVALID = "Not a valid user";
    protected final String USER_NOT_ADMIN = "Not an admin user";

    protected boolean isValidUser(String username) {
        User user = userDAO.findByUsername(username);
        return user != null;
    }
}
