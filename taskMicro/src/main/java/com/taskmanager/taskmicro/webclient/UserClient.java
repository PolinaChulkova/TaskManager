package com.taskmanager.taskmicro.webclient;

import com.taskmanager.taskmicro.dto.UserInfoDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Reader;
import java.util.List;
import java.util.Set;

@Component
public class UserClient {

    private static final String baseUrl = "http://localhost:8765/user-micro/user";

    public List<UserInfoDto> getAllUsersInfo() {
        Mono<List<UserInfoDto>> response = WebClient.create(baseUrl)
                .get()
                .uri("/user-info")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserInfoDto>>() {});
        return response.block();
    }
}
