package com.taskmanager.taskmicro.controller;

import com.taskmanager.taskmicro.dto.CreateTaskDto;
import com.taskmanager.taskmicro.dto.StatisticsDto;
import com.taskmanager.taskmicro.mapper.TaskMapper;
import com.taskmanager.taskmicro.service.TaskService;
import com.taskmanager.taskmicro.entity.Task;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
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
    public ResponseEntity<Task> getTaskByTaskId(@PathVariable("taskId") Long taskId) {
        return ResponseEntity.ok(taskService.getTaskByTaskId(taskId));
    }

//    @GetMapping("/statistics/{userId}")
//    public ResponseEntity<StatisticsDto> getStatisticsByUserId(@PathVariable Long userId,
//                                                               @RequestParam(defaultValue = "years") String period,
//                                                               @RequestParam Integer year,
//                                                               @RequestParam @Size(min = 1, max = 12) Integer month) {
//        return ResponseEntity.ok(taskService.getStatistic(userId, period));
//    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskByTaskId(@PathVariable("taskId") Long taskId) {
        taskService.deleteTaskByTaskId(taskId);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDto dto) {
        return ResponseEntity.ok(taskService.createTask(TaskMapper.toEntity(dto)));
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<Task> updateTaskByFields(@PathVariable("taskId") Long taskId,
                                                   @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(taskService.updateTaskByTaskIdAndFields(taskId, fields));
    }
}
