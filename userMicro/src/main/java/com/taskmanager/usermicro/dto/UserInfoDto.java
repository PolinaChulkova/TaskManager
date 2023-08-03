package com.taskmanager.usermicro.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoDto implements Serializable {
    private Long userId;
    private String email;
}
