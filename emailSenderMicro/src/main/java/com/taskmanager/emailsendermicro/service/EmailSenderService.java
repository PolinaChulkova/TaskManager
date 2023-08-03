package com.taskmanager.emailsendermicro.service;

import com.taskmanager.emailsendermicro.dto.EmailDto;

public interface EmailSenderService {
    void sendEmail(EmailDto emailDto);
}
