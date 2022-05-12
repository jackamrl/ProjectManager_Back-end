/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fgotl
 */
@Entity
@Table(name = "task")
@NamedQueries({
        @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "Task.size", query = "SELECT COUNT(*) FROM Task t"),
        @NamedQuery(name = "Task.findByIdTask", query = "SELECT t FROM Task t WHERE t.idTask = :idTask"),
        @NamedQuery(name = "Task.findByTaskName", query = "SELECT t FROM Task t WHERE t.taskName = :taskName")})
public class Task extends AbstractEntity implements EntityItem<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_task")
    private Integer idTask;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "task_name")
    private String taskName;
    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    @ManyToOne(optional = false)
    private Project project;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<TaskLog> taskLogs;

    public Task() {
    }

    public Task(Integer idTask) {
        this.idTask = idTask;
    }

    public Task(Integer idTask, String taskName) {
        this.idTask = idTask;
        this.taskName = taskName;
    }
    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    /*
    @JsonProperty("project")
    public Project getProject() {
        return project;
    }*/

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getIdProject(){
        return project.getIdProject();
    }

    public String getProjectName(){
        return project.getProjectName();
    }
    /*
    public void setProjectName (String pname){
        this.project.getProjectName()=pname;
    }*/



    public List<TaskLog> getTaskLogs() {
        return taskLogs;
    }

    public int getRelationWithTaskLogs(){

        if (taskLogs==null){
            return 0;
        }
        else {
            return taskLogs.size();
        }

    }

    public void setTaskLogs(List<TaskLog> taskLogs) {
        this.taskLogs = taskLogs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTask != null ? idTask.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.idTask == null && other.idTask != null) || (this.idTask != null && !this.idTask.equals(other.idTask))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.projectmanager.Task[ idTask=" + idTask + " ]";
    }

    @Override

    public Integer getId() {
        return idTask;
    }

}
