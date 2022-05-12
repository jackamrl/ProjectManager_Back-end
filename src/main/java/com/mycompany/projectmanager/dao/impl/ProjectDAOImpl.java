/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao.impl;

import com.mycompany.projectmanager.dao.ProjectDAO;
import com.mycompany.projectmanager.entities.Project;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;


@Repository("projectDAO")
@Transactional
public class ProjectDAOImpl extends GenericDAOImpl<Project,Integer>implements ProjectDAO {

    public ProjectDAOImpl() {
        super(Project.class);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Project> findAll() {
        return em.createNamedQuery("Project.findAll").getResultList();
    }


    @Override
    public Long projectSize() {
        return ((Long)em.createNamedQuery("Project.size").getSingleResult());
    }
}
