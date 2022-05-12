/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "user_log")
@NamedQueries({
        @NamedQuery(name = "UserLog.findAll", query = "SELECT u FROM UserLog u"),
        @NamedQuery(name = "UserLog.findByIdUserLog", query = "SELECT u FROM UserLog u WHERE u.idUserLog = :idUserLog"),
        @NamedQuery(name = "UserLog.findByUsername", query = "SELECT u FROM UserLog u WHERE u.username = :username"),
        @NamedQuery(name = "UserLog.findByIpAddress", query = "SELECT u FROM UserLog u WHERE u.ipAddress = :ipAddress"),
        @NamedQuery(name = "UserLog.findByStatus", query = "SELECT u FROM UserLog u WHERE u.status = :status"),
        @NamedQuery(name = "UserLog.findByLogDate", query = "SELECT u FROM UserLog u WHERE u.logDate = :logDate")})
public class UserLog extends AbstractEntity implements EntityItem<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_log")
    private Integer idUserLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ip_address")
    private String ipAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;

    public UserLog() {
    }

    public UserLog(Integer idUserLog) {
        this.idUserLog = idUserLog;
    }

    public UserLog(Integer idUserLog, String username, String ipAddress, Character status) {
        this.idUserLog = idUserLog;
        this.username = username;
        this.ipAddress = ipAddress;
        this.status = status;
    }

    public Integer getIdUserLog() {
        return idUserLog;
    }

    public void setIdUserLog(Integer idUserLog) {
        this.idUserLog = idUserLog;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserLog != null ? idUserLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLog)) {
            return false;
        }
        UserLog other = (UserLog) object;
        if ((this.idUserLog == null && other.idUserLog != null) || (this.idUserLog != null && !this.idUserLog.equals(other.idUserLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.projectmanager.dao.UserLog[ idUserLog=" + idUserLog + " ]";
    }

    @Override
    public Integer getId() {
        return idUserLog;
    }

}
