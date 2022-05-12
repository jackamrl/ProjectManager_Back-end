package com.mycompany.projectmanager.service.impl;

import com.mycompany.projectmanager.dao.ProjectDAO;
import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.repo.ProjectRepo;
import com.mycompany.projectmanager.service.AbstractService;
import com.mycompany.projectmanager.service.CompanyService;
import com.mycompany.projectmanager.service.ProjectService;
import com.mycompany.projectmanager.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class ProjectServiceImpl extends AbstractService implements ProjectService {

    protected ProjectDAO projectDAO;

    private ProjectRepo projectRepo;

    private CompanyService companyService;

    private CompanyServiceImpl companyServiceImpl;

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO, ProjectRepo projectRepo, CompanyService companyService, CompanyServiceImpl companyServiceImpl) {
        this.projectDAO = projectDAO;
        this.projectRepo = projectRepo;
        this.companyService = companyService;
        this.companyServiceImpl = companyServiceImpl;
    }

    @Override
    public Result<Project> store(Integer idProject, Integer idCompany, String projectName, String actionUsername) {
        return null;
    }

    @Override
    public Result<Project> remove(Integer idProject, String actionUsername) {
        return null;
    }

    @Override
    public Result<Project> find(Integer idProject, String actionUsername) {
        return null;
    }

    @Override
    public Result<List<Project>> findAll(String actionUsername) {
        return null;
    }

    @Override
    public Project addProject(Project project) {
        List <Task> taskList = new ArrayList<>();
        //System.out.println("hello");
//        Company company = this.companyService.findCompanyById(36);
        Company company = this.companyService.findCompanyById(project.getCompanyId());
//        Company cmp = new Company();
        //cmp.setIdCompany(36);
        //System.out.println(project.getCompanyId());
        //System.out.println(company);
        project.setCompany(company);
        //project.setIdProject(UUID.randomUUID().variant());
        return projectRepo.save(project);
    }

    @Override
    public Project findProjectById(Integer idProject) {
        return projectRepo.findById(idProject).orElseThrow(()-> new IllegalStateException("Le projet"+idProject+"n'existe pas"));
    }
}
