package com.taskmanager.emailsendermicro.mq;

import com.taskmanager.emailsendermicro.dto.EmailDto;
import com.taskmanager.emailsendermicro.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class MessageFunc {

    private final EmailSenderService emailSenderService;

    @Bean
    public Consumer<Message<EmailDto>> sendEmail() {
        return emailMessage -> emailSenderService.sendEmail(emailMessage.getPayload());
    }
}
