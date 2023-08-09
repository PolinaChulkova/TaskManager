package com.taskmanager.usermicro.controller;

import com.taskmanager.usermicro.dto.RegistrationDto;
import com.taskmanager.usermicro.entity.User;
import com.taskmanager.usermicro.mapper.UserMapper;
import com.taskmanager.usermicro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody RegistrationDto dto) {

        return ResponseEntity.ok(userService.createUser(UserMapper.toEntity(dto)));
    }
}
