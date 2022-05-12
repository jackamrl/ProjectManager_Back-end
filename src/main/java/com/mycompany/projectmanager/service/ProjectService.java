/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.vo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Administrateur
 */
@Service
public interface ProjectService {

    public Result<Project> store(
            Integer idProject,
            Integer idCompany,
            String projectName,
            String actionUsername);

    public Result<Project> remove(Integer idProject, String actionUsername);

    public Result<Project> find(Integer idProject,String actionUsername);

    public Result<List<Project>> findAll(String actionUsername);
    public Project addProject(Project project);
    public Project findProjectById(Integer idProject);
}
