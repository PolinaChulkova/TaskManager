package com.taskmanager.taskmicro.mq;

import com.taskmanager.taskmicro.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageFuncAction {
    private final MessageFunc messageFuncConfig;

    public void sendEmail(EmailDto emailDto) {
        log.info("Отправка emailDto в очередь");
        messageFuncConfig.getInnerBus().emitNext(MessageBuilder.withPayload(emailDto).build(),
                Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
