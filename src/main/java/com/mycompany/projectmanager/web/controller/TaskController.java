package com.mycompany.projectmanager.web.controller;

import com.mycompany.projectmanager.dao.TaskDAO;
import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController implements Serializable {

    private final TaskDAO taskDAO;
    final TaskService taskService;

    @Autowired
    public TaskController(TaskDAO taskDAO, TaskService taskService) {
        this.taskDAO = taskDAO;
        this.taskService = taskService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tasksList")
    public ResponseEntity<List<Task>> taskList(){
        List<Task> tasks = taskDAO.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tasksSize")
    public ResponseEntity<Long> taskSize(){
        Long taskSize = taskDAO.taskSize();
        return new ResponseEntity<>(taskSize,HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Task>addTask(@RequestBody Task task){
        Task newTask = taskService.addTask(task);
        return new ResponseEntity<>(newTask,HttpStatus.CREATED);
    }
}
