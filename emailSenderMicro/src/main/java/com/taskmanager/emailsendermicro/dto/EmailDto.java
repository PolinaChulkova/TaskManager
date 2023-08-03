package com.taskmanager.emailsendermicro.dto;

import lombok.Data;

@Data
public class EmailDto {
    private final String to;
    private final String subject;
    private final String text;
}
