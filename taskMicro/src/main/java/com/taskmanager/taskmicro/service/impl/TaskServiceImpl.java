package com.taskmanager.taskmicro.service.impl;

import com.taskmanager.taskmicro.entity.Task;
import com.taskmanager.taskmicro.repository.TaskRepository;
import com.taskmanager.taskmicro.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task getTaskByTaskId(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Задача с taskId = " + taskId + " не найдена!"));
    }

    @Override
    public Page<Task> getTasksByUserId(Long userId, Pageable pageable) {
        return taskRepository.getAllByUserId(userId, pageable);
    }

    @Override
    public void deleteTaskByTaskId(Long taskId) {
        try {
            taskRepository.deleteById(taskId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Задача с taskId = " + taskId + " не найдена!");
        }
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskByTaskIdAndFields(Long taskId, Map<String, Object> fields) {
        Task task = getTaskByTaskId(taskId);

        fields.remove("taskId");
        fields.remove("userId");

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Task.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, task, value);
        });

        return taskRepository.save(task);
    }

}