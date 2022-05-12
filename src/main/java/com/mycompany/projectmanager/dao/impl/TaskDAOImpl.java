/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao.impl;

import com.mycompany.projectmanager.dao.TaskDAO;
import com.mycompany.projectmanager.entities.Task;
import java.util.List;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("taskDAO")
@Transactional
public class TaskDAOImpl extends GenericDAOImpl<Task,Integer>implements TaskDAO {

    public TaskDAOImpl() {
        super(Task.class);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Task> findAll() {
        return em.createNamedQuery("Task.findAll").getResultList();
    }

    @Override
    public Long taskSize() {
        return ((Long)em.createNamedQuery("Task.size").getSingleResult());
    }
}
