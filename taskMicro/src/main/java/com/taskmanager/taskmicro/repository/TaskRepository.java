package com.taskmanager.taskmicro.repository;

import com.taskmicro.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> getAllByUserId(Long userId, Pageable pageable);


}
