package com.mycompany.projectmanager.repo;

import com.mycompany.projectmanager.entities.TaskLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskLogRepo extends JpaRepository<TaskLog, Integer> {
    @Query(value = "SELECT * FROM task_log tl WHERE tl.username =?1", nativeQuery = true)
    List<TaskLog> findByUsername(String username);
}
