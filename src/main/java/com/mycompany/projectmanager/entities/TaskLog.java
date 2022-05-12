/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.entities;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fgotl
 */
@Entity
@Table(name = "task_log")
@NamedQueries({
        @NamedQuery(name = "TaskLog.findAll", query = "SELECT t FROM TaskLog t"),
        @NamedQuery(name = "TaskLog.findByIdTaskLog", query = "SELECT t FROM TaskLog t WHERE t.idTaskLog = :idTaskLog"),
        @NamedQuery(name = "TaskLog.findByTaskDescription", query = "SELECT t FROM TaskLog t WHERE t.taskDescription = :taskDescription"),
        @NamedQuery(name = "TaskLog.findByTaskLogDate", query = "SELECT t FROM TaskLog t WHERE t.taskLogDate = :taskLogDate"),
        @NamedQuery(name = "TaskLog.findByTaskMinutes", query = "SELECT t FROM TaskLog t WHERE t.taskMinutes = :taskMinutes"),
        @NamedQuery(name = "TaskLog.findTaskLogCountByTask", query = "SELECT COUNT(t) FROM TaskLog t WHERE t.task = :task"),
        @NamedQuery(name = "TaskLog.findTaskLogCountByUser", query = "SELECT COUNT(t) FROM TaskLog t WHERE t.user = :user"),
        @NamedQuery(name = "TaskLog.findByUser", query = "SELECT t FROM TaskLog t WHERE t.user = :user and t.taskLogDate BETWEEN :startDate AND :endDate ORDER BY t.taskLogDate ASC"),
        @NamedQuery(name = "TaskLog.findByUsername", query = "SELECT t FROM TaskLog t WHERE t.user = :user")
})
public class TaskLog extends AbstractEntity implements EntityItem<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_task_log")
    private Integer idTaskLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "task_description")
    private String taskDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "task_log_date")
    @Temporal(TemporalType.DATE)
    private Date taskLogDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "task_minutes")
    private int taskMinutes;
    @JoinColumn(name = "id_task", referencedColumnName = "id_task")
    @ManyToOne(optional = false)
    private Task task;

    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User user;

    public TaskLog() {
    }

    public TaskLog(Integer idTaskLog) {
        this.idTaskLog = idTaskLog;
    }

    public TaskLog(Integer idTaskLog, String taskDescription, Date taskLogDate, int taskMinutes) {
        this.idTaskLog = idTaskLog;
        this.taskDescription = taskDescription;
        this.taskLogDate = taskLogDate;
        this.taskMinutes = taskMinutes;
    }

    public Integer getIdTaskLog() {
        return idTaskLog;
    }

    public void setIdTaskLog(Integer idTaskLog) {
        this.idTaskLog = idTaskLog;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getTaskLogDate() {
        return taskLogDate;
    }

    public void setTaskLogDate(Date taskLogDate) {
        this.taskLogDate = taskLogDate;
    }

    public int getTaskMinutes() {
        return taskMinutes;
    }

    public void setTaskMinutes(int taskMinutes) {
        this.taskMinutes = taskMinutes;
    }

   /* public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }*/

    public int getTaskId(){
        return task.getIdTask();
    }
    public String getTaskIdName(){
        return task.getTaskName();
    }

    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getUserUsername(){
        return user.getUsername();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaskLog != null ? idTaskLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskLog)) {
            return false;
        }
        TaskLog other = (TaskLog) object;
        if ((this.idTaskLog == null && other.idTaskLog != null) || (this.idTaskLog != null && !this.idTaskLog.equals(other.idTaskLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.projectmanager.TaskLog[ idTaskLog=" + idTaskLog + " ]";
    }

    @Override
    public Integer getId() {
        return idTaskLog;
    }

}
