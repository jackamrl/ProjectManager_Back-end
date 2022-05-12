package com.mycompany.projectmanager.web.controller;

import com.mycompany.projectmanager.dao.ProjectDAO;
import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController implements Serializable {

    private final ProjectService projectService;
    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectDAO projectDAO) {
        this.projectService = projectService;
        this.projectDAO = projectDAO;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projectsList")
    public ResponseEntity<List<Project>> projectList(){
        List<Project> projects = projectDAO.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projectsSize")
    public ResponseEntity<Long> projectSize(){
        Long projSize = projectDAO.projectSize();
        return new ResponseEntity<>(projSize,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Project>addProject(@RequestBody Project project){
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject,HttpStatus.CREATED);
    }
}
