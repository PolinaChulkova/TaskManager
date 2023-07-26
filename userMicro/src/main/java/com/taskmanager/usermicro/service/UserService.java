package com.taskmanager.usermicro.service;

import com.taskmanager.usermicro.entity.User;

import java.util.Map;

public interface UserService {

    User createUser(User user);
    User getUserByUserId(Long userId);
    User updateUserByUserIdAndFields(Long userId, Map<String, Object> fields);
}
