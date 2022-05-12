package com.mycompany.projectmanager.service.impl;

import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.repo.TaskRepo;
import com.mycompany.projectmanager.service.AbstractService;
import com.mycompany.projectmanager.service.ProjectService;
import com.mycompany.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class TaskServiceImpl extends AbstractService implements TaskService {

    protected TaskRepo taskRepo;
    protected ProjectService projectService;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo, ProjectService projectService) {
        this.taskRepo = taskRepo;
        this.projectService = projectService;
    }

    @Override
    public Task addTask(Task task) {
        Project project = this.projectService.findProjectById(task.getIdProject());
        task.setProject(project);
        return taskRepo.save(task);
    }
}
