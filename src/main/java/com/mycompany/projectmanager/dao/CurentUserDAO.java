package com.mycompany.projectmanager.dao;


import com.mycompany.projectmanager.entities.CurentUser;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public interface CurentUserDAO extends GenericDAO<CurentUser, String>{
    public List<CurentUser> findAll();
    public CurentUser addUser(CurentUser curentuser);
}
