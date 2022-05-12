
package com.mycompany.projectmanager.dao;
import com.mycompany.projectmanager.entities.Task;
import java.util.List;


public interface TaskDAO extends GenericDAO<Task, Integer>{
    public List<Task>findAll();
    public Long taskSize();
}
