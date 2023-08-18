package com.taskmanager.taskmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class StatisticsDto {
    private LocalDate periodBeginDate;
    private LocalDate periodEndDate;
    private int countAllTasks;
    private int countCompletedTasks;
    private int countOutstandingTasks;
}
