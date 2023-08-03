package com.taskmanager.taskmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto implements Serializable {
    private Long userId;
    private String email;
}
