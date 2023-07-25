package com.taskmanager.usermicro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usr")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private char[] password;

    @ElementCollection
    @CollectionTable(name = "user_tasks", joinColumns = @JoinColumn(name = "user_id"))
    private List<Long> taskIds = new ArrayList<>();
}
