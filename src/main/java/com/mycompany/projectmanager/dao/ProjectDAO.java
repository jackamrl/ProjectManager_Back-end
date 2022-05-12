package com.mycompany.projectmanager.dao;

import com.mycompany.projectmanager.entities.Project;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.List;

public interface ProjectDAO extends GenericDAO<Project,Integer> {
    @ElementCollection(fetch= FetchType.LAZY)
    public List<Project>findAll();
    public Long projectSize();
}
