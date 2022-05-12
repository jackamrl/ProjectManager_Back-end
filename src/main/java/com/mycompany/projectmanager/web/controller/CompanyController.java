package com.mycompany.projectmanager.web.controller;

import com.mycompany.projectmanager.dao.CompanyDAO;
import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.entities.User;
import com.mycompany.projectmanager.service.CompanyService;
import com.mycompany.projectmanager.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/company")

public class CompanyController implements Serializable {

    final CompanyService companyService;
    //@Autowired
    //private User actionUser;

    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyController(CompanyService companyService, /*User actionUser,*/ CompanyDAO companyDAO) {
        this.companyService = companyService;
        //this.actionUser = actionUser;
        this.companyDAO = companyDAO;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/companiesList")
    public ResponseEntity<List<Company>> listeComp(){
        List<Company> companies = companyService.nfindAll("jackdev");
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/companiesSize")
    public ResponseEntity<Long> compSize(){
        Long compSize = companyDAO.companiesSize();
        return new ResponseEntity<>(compSize,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Company>addCompany(@RequestBody Company company){
        Company newCompany = companyService.addCompany(company);
        return new ResponseEntity<>(newCompany,HttpStatus.CREATED);
    }

    /*@GetMapping("/Companies")
    public ResponseEntity<List<Company>> listeComp(){
        List<Company>companies = companyDAO.findAll();
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }*/
    /*
    @GetMapping("/Company")
    public List<Company> listeComp(){

        return (List<Company>) companyDAO.findAll();
    }*/

    /*@GetMapping("/Company")
    public Result <Company> getAllCompanies(){
        boolean sucees = true;
        List<Company> companies = (List<Company>) companyService.findAll("jackdev");
        return new Result <Company>(sucees, (Company) companies);
    }*/

}
