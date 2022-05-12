/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.entities;

import java.util.List;
import java.util.Optional;
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
@Table(name = "project")
@NamedQueries({
        @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
        @NamedQuery(name = "Project.size", query = "SELECT COUNT(*) FROM Project p"),
        @NamedQuery(name = "Project.findByIdProject", query = "SELECT p FROM Project p WHERE p.idProject = :idProject"),
        @NamedQuery(name = "Project.findByProjectName", query = "SELECT p FROM Project p WHERE p.projectName = :projectName")})
public class Project extends AbstractEntity implements EntityItem<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_project")
    private Integer idProject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "project_name")
    private String projectName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Task> taskList;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false)
    private Company company;
    //private int comp = company.getIdCompany();

    public Project() {
    }

    public Project(Integer idProject) {
        this.idProject = idProject;
    }

    public Project(Integer idProject, String projectName) {
        this.idProject = idProject;
        this.projectName = projectName;
    }


    public Integer getIdProject() {
        return idProject;
    }

    public void  setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTaskList() {

        if (taskList==null){
            return null;
        }
        else {
            return taskList;
        }

    }

    public int getRelationWithTask(){
        if(taskList == null){
            return 0;
        }
        else{
            return taskList.size();}
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    //@JsonProperty("company")
    public Integer getCompanyId() {
        return company.getIdCompany();
    }

//   public Company getCompany() {
//        return company;
//    }

    public void setCompany(Company company) {
        this.company = company;
    }


//    public void setCompanyId(Integer newcompanyId){
//        this.company.getIdCompany()=newcompanyId;
//    }


    public String getCompanyName(){
        if(company.getCompanyName()==null){
            return "";
        }
        else
            return company.getCompanyName();
    }

    /*public void setCompanyName(String projectName){
        this.projectName=projectName;
    }*/


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProject != null ? idProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idProject == null && other.idProject != null) || (this.idProject != null && !this.idProject.equals(other.idProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.projectmanager.Project[ idProject=" + idProject + " ]";
    }

    @Override
    public Integer getId() {
        return null;
    }

}
