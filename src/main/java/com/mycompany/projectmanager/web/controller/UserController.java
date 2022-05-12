package com.mycompany.projectmanager.web.controller;


import com.mycompany.projectmanager.dao.UserDAO;
import com.mycompany.projectmanager.entities.User;
import com.mycompany.projectmanager.repo.UserRepo;
import com.mycompany.projectmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/us")
@CrossOrigin(origins = "*")
public class UserController implements Serializable {

    private final UserDAO userDAO;
    private final UserRepo userRepo;
    private final UserService userService;


    @Autowired
    public UserController(UserDAO userDAO, UserRepo userRepo, UserService userService) {
        this.userDAO = userDAO;

        this.userRepo = userRepo;
        this.userService = userService;
    }

    /*@GetMapping("/user")
    public List<User> findUser(){
        return userDAO.findAll();
    }*/
    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public ResponseEntity<List<User>>findUsers(){
        List<User> users = userDAO.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/finduser")
    public ResponseEntity<User>findUser(@RequestBody String dataUsername){
        System.out.println(dataUsername);
        User newuser = userService.findUserByUsername(dataUsername);
        System.out.println(newuser);
        if (newuser.isAdmin()){
            return new ResponseEntity<>(newuser, HttpStatus.OK);
        }
        return (ResponseEntity<User>) ResponseEntity.internalServerError();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/finduserSimple")
    public ResponseEntity<User>findUserSimple(@RequestBody String dataUsername){
        System.out.println(dataUsername);
        User newuser = userService.findUserByUsername(dataUsername);
        System.out.println(newuser);
        return new ResponseEntity<>(newuser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody User userData){
        System.out.println(userData);
        User newUser = userDAO.findByUsername(userData.getUsername());
        if (newUser.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(newUser);

        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }





}
