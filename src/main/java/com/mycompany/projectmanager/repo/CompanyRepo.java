package com.mycompany.projectmanager.repo;

import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
//    Company findCompanyById(Integer idCompany);

}
