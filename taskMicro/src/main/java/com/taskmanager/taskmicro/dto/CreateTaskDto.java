package com.taskmanager.taskmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Calendar;

@AllArgsConstructor
@Getter
public class CreateTaskDto {
    private final String title;
    private final String description;
    private final Boolean status;
    private final Calendar completionDate;
    private final Long userId;
}
