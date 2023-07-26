package com.taskmanager.usermicro.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegistrationDto {
    private final String email;
    private final String name;
    private final char[] password;
}
