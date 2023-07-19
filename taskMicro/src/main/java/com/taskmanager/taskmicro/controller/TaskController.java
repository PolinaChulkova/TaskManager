package com.taskmanager.taskmicro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(taskService.getTasksByUserId(userId));
    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskByTaskId(@PathVariable("taskId") Long taskId) {
        taskService.deleteTaskByTaskId(taskId);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDto dto) {
        return new ResponseEntity<>(taskService.createTask(dto));
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<Task> updateTaskByFields(@PathVariable("taskId") Long taskId,
                                                   Map<String, Object> fields) {
        return new ResponseEntity<>(taskService.updateTaskByFields(taskId, fields));
    }
}
