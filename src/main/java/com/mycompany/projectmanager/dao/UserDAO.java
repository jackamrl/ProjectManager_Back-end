package com.mycompany.projectmanager.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.projectmanager.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public interface UserDAO extends GenericDAO<User, String> {
    public List<User>findAll();
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User addUser(User user);
}

