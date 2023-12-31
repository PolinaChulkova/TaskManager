package com.taskmanager.usermicro.controller;

import com.taskmanager.usermicro.dto.UserInfoDto;
import com.taskmanager.usermicro.entity.User;
import com.taskmanager.usermicro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }

    @GetMapping("/user-info")
    public ResponseEntity<List<UserInfoDto>> getAllUserInfo() {
        return ResponseEntity.ok(
                userService.getAllUsers().stream()
                        .map(u -> new UserInfoDto(u.getUserId(), u.getEmail()))
                        .collect(Collectors.toList())
        );
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateUserByFields(@PathVariable("userId") Long userId,
                                                   @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(userService.updateUserByUserIdAndFields(userId, fields));
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUserByUserId(userId);
    }

}
