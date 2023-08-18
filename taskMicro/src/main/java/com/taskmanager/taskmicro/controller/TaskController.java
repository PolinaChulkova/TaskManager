package com.taskmanager.taskmicro.controller;

import com.taskmanager.taskmicro.dto.CreateTaskDto;
import com.taskmanager.taskmicro.entity.Task;
import com.taskmanager.taskmicro.mapper.TaskMapper;
import com.taskmanager.taskmicro.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{userId}/{page}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable("userId") Long userId,
                                                       @PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return ResponseEntity.ok(taskService.getTasksByUserId(userId, pageable).getContent());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskByTaskId(@PathVariable("taskId") long taskId) {
        return ResponseEntity.ok(taskService.getTaskByTaskId(taskId));
    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskByTaskId(@PathVariable("taskId") long taskId) {
        taskService.deleteTaskByTaskId(taskId);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDto dto) {
        return ResponseEntity.ok(taskService.createTask(TaskMapper.toEntity(dto)));
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<Task> updateTaskByFields(@PathVariable("taskId") long taskId,
                                                   @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(taskService.updateTaskByTaskIdAndFields(taskId, fields));
    }
}
