package com.taskmanager.taskmicro.service.impl;

import com.taskmanager.taskmicro.dto.CreateTaskDto;
import com.taskmanager.taskmicro.mapper.TaskMapper;
import com.taskmanager.taskmicro.repository.TaskRepository;
import com.taskmanager.taskmicro.service.TaskService;
import com.taskmicro.entity.Task;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;


    @Override
    public Task getTaskByTaskId(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Задача с taskId = " + taskId + " не найдена!"));
    }

    @Override
    public Page<Task> getTasksByUserId(Long userId, Pageable pageable) {
        return taskRepository.getAllByUserId(userId, pageable);
    }

    @Override
    public void deleteTaskByTaskId(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskByFields(Long taskId, Map<String, Object> fields) {
        Task task = getTaskByTaskId(taskId);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Task.class, "key");
            Objects.requireNonNull(field).setAccessible(true);
            ReflectionUtils.setField(field, task, value);
            });
            return taskRepository.save(task);
        }
}