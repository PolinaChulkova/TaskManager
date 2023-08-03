package com.taskmanager.emailsendermicro.model;

import lombok.Data;

@Data
public class Email {
    private final String to;
    private final String subject;
    private final String text;
}
