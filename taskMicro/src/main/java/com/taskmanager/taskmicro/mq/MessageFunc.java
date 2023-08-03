package com.taskmanager.taskmicro.mq;

import com.taskmanager.taskmicro.dto.Email;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.util.function.Supplier;

@Configuration
@Getter
public class MessageFunc {

    private final Sinks.Many<Message<Email>> innerBus = Sinks.many().multicast()
            .onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);

    @Bean
    public Supplier<Flux<Message<Email>>> newEmailProduce() {
        return innerBus::asFlux;
    }
}
