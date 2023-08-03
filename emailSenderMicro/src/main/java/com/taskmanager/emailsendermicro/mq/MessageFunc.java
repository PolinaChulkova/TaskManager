package com.taskmanager.emailsendermicro.mq;

import com.taskmanager.emailsendermicro.model.Email;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
@Getter
public class MessageFunc {

    @Bean
    public Consumer<Message<Email>> getEmail() {
        return emailMessage -> emailSender.sendEmail(new Email(

        ))
    }
}
