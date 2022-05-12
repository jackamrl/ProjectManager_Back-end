/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao;

import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskLogDAO extends GenericDAO<TaskLog, Integer>{
    public List<TaskLog>findAll();
    //public List<TaskLog>findByUser(User user, Date startDate, Date endDate);
    public List<TaskLog>findByUser(String username);
    //public List<TaskLog>findByUser(User user);
    public long findTaskLogCountByTask(Task task);
    public long findTaskLogCountByUser(User user);



}
