package com.taskmanager.taskmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Calendar;

@AllArgsConstructor
@Getter
public class CreateTaskDto {
    private final String title;
    private final String description;
    private final Boolean status;
    private final LocalDate plannedDueDate;
    private final Long userId;
}
