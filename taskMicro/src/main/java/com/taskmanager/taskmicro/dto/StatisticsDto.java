package com.taskmanager.taskmicro.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatisticsDto {
    private LocalDate periodBeginDate;
    private LocalDate periodEndDate;
    private int countAllTasks;
    private int countCompletedTasks;
    private int countOutstandingTasks;
}
