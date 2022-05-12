package com.mycompany.projectmanager.service.impl;

import com.mycompany.projectmanager.dao.GenericDAO;
import com.mycompany.projectmanager.entities.AbstractEntity;
import com.mycompany.projectmanager.entities.User;
import com.mycompany.projectmanager.repo.CompanyRepo;
import com.mycompany.projectmanager.repo.UserRepo;
import com.mycompany.projectmanager.service.AbstractService;
import com.mycompany.projectmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    public UserRepo userRepo;

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }
}

