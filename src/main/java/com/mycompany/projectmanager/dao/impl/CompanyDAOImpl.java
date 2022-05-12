/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao.impl;

import com.mycompany.projectmanager.dao.CompanyDAO;
import com.mycompany.projectmanager.entities.Company;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("companyDAO")
@Transactional
public class CompanyDAOImpl extends GenericDAOImpl<Company,Integer>implements CompanyDAO {

    public CompanyDAOImpl() {
        super(Company.class);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Company> findAll() {
        return em.createNamedQuery("Company.findAll").getResultList();
    }

    @Override
    public Long companiesSize() {
        return ((Long)em.createNamedQuery("Company.size").getSingleResult());
    }
}
