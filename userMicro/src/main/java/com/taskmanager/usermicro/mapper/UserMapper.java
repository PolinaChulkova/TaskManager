package com.taskmanager.usermicro.mapper;

import com.taskmanager.usermicro.dto.RegistrationDto;
import com.taskmanager.usermicro.entity.User;

public class UserMapper {

    public static User toEntity(RegistrationDto dto) {
        return new User(
                dto.getEmail(),
                dto.getName(),
                dto.getPassword()
        );
    }
}
