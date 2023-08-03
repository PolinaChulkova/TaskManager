package com.taskmanager.taskmicro.mq;

import com.taskmanager.taskmicro.dto.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class MessageFuncAction {
    private final MessageFunc messageFuncConfig;

    public void sendEmail(Email email) {
        messageFuncConfig.getInnerBus().emitNext(MessageBuilder.withPayload(email).build(),
                Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
