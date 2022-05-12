package com.mycompany.projectmanager.dao;

import com.mycompany.projectmanager.entities.Company;
import java.util.List;

public interface CompanyDAO extends GenericDAO<Company,Integer>{
    public List<Company>findAll();
    public Long companiesSize();
}
