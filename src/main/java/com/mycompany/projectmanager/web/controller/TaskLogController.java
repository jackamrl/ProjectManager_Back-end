package com.mycompany.projectmanager.web.controller;

import com.mycompany.projectmanager.dao.TaskLogDAO;
import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/taskLog")
public class TaskLogController implements Serializable {

    private final TaskLogDAO taskLogDAO;
    private final TaskLogService taskLogService;

    @Autowired
    public TaskLogController(TaskLogDAO taskLogDAO, TaskLogService taskLogService) {
        this.taskLogDAO = taskLogDAO;
        this.taskLogService = taskLogService;
    }

    @CrossOrigin("*")
    @GetMapping("/taskLogList")
    public ResponseEntity<List<TaskLog>> taskLogList(){
        List<TaskLog> taskLogs = taskLogDAO.findAll();
        return new ResponseEntity<>(taskLogs,HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/taskbyuser")
    public ResponseEntity<?>loginUser(@RequestBody String usernameData){
        System.out.println(usernameData);
        List<TaskLog> taskLogLists = taskLogService.findTaskLogByUser(usernameData);
        if (!taskLogLists.isEmpty())
            return ResponseEntity.ok(taskLogLists);

        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }

   @CrossOrigin("*")
   @PostMapping("/taskbyusern")
    public ResponseEntity<?>taskbyUser(@RequestBody String dataUsername){
        System.out.println(dataUsername);
        List<TaskLog> taskLogLists = taskLogDAO.findByUser(dataUsername);
        if (!taskLogLists.isEmpty())
            return ResponseEntity.ok(taskLogLists);

        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<TaskLog>addTaskLog(@RequestBody TaskLog taskLog){
        TaskLog newTasKLog = taskLogService.addTaskLog(taskLog);
        return new ResponseEntity<>(newTasKLog,HttpStatus.CREATED);
    }

    /*
    @CrossOrigin("*")
    @GetMapping("/taskbyuser")
    public ResponseEntity<List<TaskLog>> getTaskLogByUser(@RequestBody String username){
        System.out.println(username);
        List<TaskLog> taskLogs = taskLogService.findTaskLogByUser(username);
        return new ResponseEntity<>(taskLogs,HttpStatus.OK);
    }*/
}
