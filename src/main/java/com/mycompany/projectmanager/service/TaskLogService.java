package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entities.TaskLog;

import java.util.List;

public interface TaskLogService {

    public List<TaskLog> findTaskLogByUser(String username);
    public TaskLog addTaskLog(TaskLog taskLog);
}
