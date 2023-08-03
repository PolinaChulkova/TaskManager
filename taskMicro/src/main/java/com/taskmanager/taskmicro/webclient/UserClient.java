package com.taskmanager.taskmicro.webclient;

import com.taskmanager.taskmicro.dto.UserInfoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Set;

@Component
public class UserClient {

    private static final String baseUrl = "http://localhost:8765/user-micro/user";

    public Set<UserInfoDto> getAllUsersInfo() {
         return WebClient.create(baseUrl)
                 .get()
                 .uri("/user-info")
                 .retrieve()
                 .bodyToFlux(Set.class)
                 .blockFirst();
    }
}
