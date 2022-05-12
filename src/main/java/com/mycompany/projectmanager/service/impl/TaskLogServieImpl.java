package com.mycompany.projectmanager.service.impl;

import com.mycompany.projectmanager.dao.UserDAO;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.entities.User;
import com.mycompany.projectmanager.repo.TaskLogRepo;
import com.mycompany.projectmanager.repo.UserRepo;
import com.mycompany.projectmanager.service.AbstractService;
import com.mycompany.projectmanager.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service("taskLogService")
public class TaskLogServieImpl extends AbstractService implements TaskLogService {

    @Autowired
    private final TaskLogRepo taskLogRepo;
    @Autowired
    private final UserDAO userDAO;
    @Autowired
    private final UserRepo userRepo;

    public TaskLogServieImpl(TaskLogRepo taskLogRepo, UserDAO userDAO, UserRepo userRepo) {
        this.taskLogRepo = taskLogRepo;
        this.userDAO = userDAO;
        this.userRepo = userRepo;
    }

    @Override
    public List<TaskLog> findTaskLogByUser(String username) {
        //Optional<User> userOptional = userRepo.findById(username) ;
        List<TaskLog> taskLogOptionnal = taskLogRepo.findByUsername(username);

            if (taskLogOptionnal.isEmpty() || taskLogOptionnal==null) {
                throw new IllegalStateException("L'utilisateur " + username + "n'a pas de tâches");
            } else {
                return taskLogOptionnal;

        }
    }

    @Override
    public TaskLog addTaskLog(TaskLog taskLog) {
        taskLog.setIdTaskLog(UUID.randomUUID().variant());
        return taskLogRepo.save(taskLog);
    }
}
