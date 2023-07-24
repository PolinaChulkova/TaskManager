package com.taskmanager.taskmicro.service;

import com.taskmicro.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TaskService {
    Task getTaskByTaskId(Long taskId);

    Page<Task> getTasksByUserId(Long userId, Pageable pageable);

    void deleteTaskByTaskId(Long taskId);

    Task createTask(Task task);

    Task updateTaskByFields(Long taskId, Map<String, Object> fields);
}
