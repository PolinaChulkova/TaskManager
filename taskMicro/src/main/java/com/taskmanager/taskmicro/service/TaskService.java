package com.taskmanager.taskmicro.service;

import com.taskmanager.taskmicro.dto.StatisticsDto;
import com.taskmanager.taskmicro.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TaskService {
    Task  getTaskByTaskId(Long taskId);

    Page<Task> getTasksByUserId(Long userId, Pageable pageable);

    void deleteTaskByTaskId(Long taskId);

    Task createTask(Task task);

    Task updateTaskByTaskIdAndFields(Long taskId, Map<String, Object> fields);

//    StatisticsDto getStatistic(Long userId, String period);
}
