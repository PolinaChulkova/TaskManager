package com.taskmanager.taskmicro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private boolean status;
    @Column(name = "completion_date")
    private LocalDate completionDate;
    @Column(name = "planned_due_date")
    private LocalDate plannedDueDate;
    @Column(name = "user_id")
    private long userId;

    public Task(long taskId, String title,
                String description, boolean status,
                LocalDate plannedDueDate, long userId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.plannedDueDate = plannedDueDate;
        this.userId = userId;
    }

    public Task(String title, String description, boolean status, LocalDate plannedDueDate, long userId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.plannedDueDate = plannedDueDate;
        this.userId = userId;
    }

    public boolean getStatus() {
        return status;
    }
}