package com.mycompany.projectmanager.dao.impl;

import com.mycompany.projectmanager.dao.CurentUserDAO;
import com.mycompany.projectmanager.entities.CurentUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository("curentUserDAO")
@Transactional
public class CurentUserDAOImpl extends GenericDAOImpl <CurentUser, String> implements CurentUserDAO {

    private GenericDAOImpl genericDAO;
    public CurentUserDAOImpl() {
        super (CurentUser.class);
    }

    @Override
    public List<CurentUser> findAll() {
        return em.createNamedQuery("Curentuser.findAll").getResultList();
    }

    @Override
    public CurentUser addUser(CurentUser curentUser) {
        return (CurentUser) em.createNamedQuery("CurentUser.insert").getResultList();
    }
}
