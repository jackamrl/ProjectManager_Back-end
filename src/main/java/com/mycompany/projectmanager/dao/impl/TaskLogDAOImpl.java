/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao.impl;

import com.mycompany.projectmanager.dao.TaskLogDAO;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.entities.User;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("taskLogDAO")
@Transactional
public class TaskLogDAOImpl extends GenericDAOImpl<TaskLog, Integer> implements TaskLogDAO {

    public TaskLogDAOImpl() {
        super(TaskLog.class);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TaskLog> findAll() {
        return em.createNamedQuery("TaskLog.findAll").getResultList();
    }

    /*@Override
    public List<TaskLog> findByUser(User user, Date startDate, Date endDate) {
        return em.createNamedQuery("TaskLog.findByUser")
                .setParameter("user", user)
                .setParameter("startDate", startDate, TemporalType.DATE)
                .setParameter("endDate", endDate, TemporalType.DATE)
                .getResultList();
    }*/
    @Override
    public List<TaskLog> findByUser(String username) {
        return em.createNamedQuery("TaskLog.findByUsername")
                .setParameter("user", username)
                .getResultList();
    }

    @Override
    public long findTaskLogCountByTask(Task task) {
        return (Long) em.createNamedQuery("TaskLog.findTaskLogCountByTask")
                .setParameter("task", task)
                .getSingleResult();
    }

    @Override
    public long findTaskLogCountByUser(User user) {
        return (Long) em.createNamedQuery("TaskLog.findTaskLogCountByUser")
                .setParameter("user", user)
                .getSingleResult();
    }


}
