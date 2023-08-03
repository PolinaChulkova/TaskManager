package com.taskmanager.taskmicro.dto;

import lombok.Data;

@Data
public class Email {
    private final String from = "jkimjdcii";
    private final String to;
    private final String subject = "Отчет о задачах за сутки";
    private final String text;


}
