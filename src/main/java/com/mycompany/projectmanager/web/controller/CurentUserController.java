package com.mycompany.projectmanager.web.controller;

import com.mycompany.projectmanager.dao.CurentUserDAO;
import com.mycompany.projectmanager.entities.CurentUser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/curentuser")
public class CurentUserController implements Serializable {

    protected final CurentUserDAO curentUserDAO;

    public CurentUserController(CurentUserDAO curentUserDAO) {
        this.curentUserDAO = curentUserDAO;
    }

    @GetMapping("/users")
    public ResponseEntity<List<CurentUser>>findUser(){
        List<CurentUser> users = curentUserDAO.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CurentUser> addUser(CurentUser curentUser){
        CurentUser newUser = curentUserDAO.addUser(curentUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
