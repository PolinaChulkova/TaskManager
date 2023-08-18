package com.taskmanager.taskmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CreateTaskDto {
    private final String title;
    private final String description;
    private final boolean status;
    private final LocalDate plannedDueDate;
    private final long userId;

    public boolean getStatus() {
        return status;
    }
}
