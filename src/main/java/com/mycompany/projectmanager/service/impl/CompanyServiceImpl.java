/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.service.impl;

/**
 *
 * @author Administrateur
 */
import com.mycompany.projectmanager.dao.CompanyDAO;
import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.entities.User;
import com.mycompany.projectmanager.repo.CompanyRepo;
import com.mycompany.projectmanager.service.AbstractService;
import com.mycompany.projectmanager.service.CompanyService;
import com.mycompany.projectmanager.vo.Result;
import com.mycompany.projectmanager.vo.ResultFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CompanyServiceImpl extends AbstractService implements CompanyService {

    protected CompanyDAO companyDAO;
    private CompanyRepo companyRepo;

//    @Qualifier("CompanyRepo")
    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO, CompanyRepo companyRepo) {
        this.companyDAO = companyDAO;
        this.companyRepo = companyRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override

    public Result<Company> find(Integer idCompany, String actionUsername) {
        if (isValidUser(actionUsername)) {
            Company company = companyDAO.find(idCompany);
            return ResultFactory.getSuccessResult(company);
        } else {
            return ResultFactory.getFailResult(USER_INVALID);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Result<Company> store(
            Integer idCompany,
            String companyName,
            String actionUsername) {
        User actionUser = userDAO.find(actionUsername);
        if (!actionUser.isAdmin()) {
            return ResultFactory.getFailResult(USER_NOT_ADMIN);
        }
        Company company;
        if (idCompany == null) {
            company = new Company();
        } else {
            company = companyDAO.find(idCompany);
            if (company == null) {
                return ResultFactory.getFailResult("Unable to find company instance with ID=" + idCompany);
            }
        }
        company.setCompanyName(companyName);
        if (company.getId() == null) {
            companyDAO.persist(company);
        } else {
            company = companyDAO.merge(company);
        }
        return ResultFactory.getSuccessResult(company);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Result<Company> remove(Integer idCompany, String actionUsername) {
        User actionUser = userDAO.find(actionUsername);
        if (!actionUser.isAdmin()) {
            return ResultFactory.getFailResult(USER_NOT_ADMIN);
        }
        if (idCompany == null) {
            return ResultFactory.getFailResult("Unable to remove Company [null idCompany]");
        }
        Company company = companyDAO.find(idCompany);
        if (company == null) {
            return ResultFactory.getFailResult("Unable to load Company for removal with idCompany=" + idCompany);
        } else {
            if (company.getProjects() == null
                    || company.getProjects().isEmpty()) {
                companyDAO.remove(company);
                String msg = "Company "
                        + company.getCompanyName() + " was deleted by " + actionUsername;
                logger.info(msg);
                return ResultFactory.getSuccessResultMsg(msg);
            } else {
                return ResultFactory.getFailResult("Company has projects assigned and could not be deleted");
            }
        }
    }
    // type Result
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Result<List<Company>> findAll(String actionUsername) {
        if (isValidUser(actionUsername)) {
            return ResultFactory.getSuccessResult(companyDAO.findAll());
        } else {
            return ResultFactory.getFailResult(USER_INVALID);
        }
    }
    //
    @Override
    public List<Company> nfindAll(String actionUsername) {
        if (isValidUser(actionUsername)) {
            return companyDAO.findAll();
        } else {
            return null;
        }

    }

    @Override
    public Company addCompany(Company company) {
        company.setIdCompany( UUID.randomUUID().variant());
        return companyRepo.save(company) ;
    }

    @Override
    public Company findCompanyById(Integer idCompany) {
        return companyRepo.findById(idCompany).orElseThrow(()-> new IllegalStateException("La compagnie"+idCompany+"n'existe pas"));
    }

    @Override
    public void nstore(Integer idCompany, String companyName, String actionUsername) {

    }

    @Override
    public void nremove(Integer idCompany, String actionUsername) {

    }

    @Override
    public Company nfind(Integer idCompany, String actionUsername) {
        return null;
    }


}
