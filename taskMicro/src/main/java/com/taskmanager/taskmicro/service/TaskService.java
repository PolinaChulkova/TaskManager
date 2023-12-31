package com.taskmanager.taskmicro.service;

import com.taskmanager.taskmicro.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TaskService {
    Task getTaskByTaskId(long taskId);

    Page<Task> getTasksByUserId(long userId, Pageable pageable);

    void deleteTaskByTaskId(long taskId);

    Task createTask(Task task);

    Task updateTaskByTaskIdAndFields(long taskId, Map<String, Object> fields);
}
