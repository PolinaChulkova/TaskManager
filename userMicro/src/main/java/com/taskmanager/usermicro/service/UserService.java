package com.taskmanager.usermicro.service;

import com.taskmanager.usermicro.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {

    User createUser(User user);
    User getUserByUserId(Long userId);
    User updateUserByUserIdAndFields(Long userId, Map<String, Object> fields);
    List<User> getAllUsers();
    void deleteUserByUserId(Long userId);
}
