package com.taskmanager.taskmicro.dto;

import lombok.Data;

@Data
public class EmailDto {
    private final String to;
    private final String subject = "Отчет о задачах за сутки";
    private final String text;
}
