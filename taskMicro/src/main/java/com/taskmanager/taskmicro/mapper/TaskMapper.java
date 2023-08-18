package com.taskmanager.taskmicro.mapper;

import com.taskmanager.taskmicro.dto.CreateTaskDto;
import com.taskmanager.taskmicro.entity.Task;

public class TaskMapper {

    public static Task toEntity(CreateTaskDto dto) {
        return new Task(
                dto.getTitle(),
                dto.getDescription(),
                dto.getStatus(),
                dto.getPlannedDueDate(),
                dto.getUserId()
        );
    }

    public static CreateTaskDto toDto(Task task) {
        return new CreateTaskDto(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPlannedDueDate(),
                task.getUserId()
        );
    }
}
