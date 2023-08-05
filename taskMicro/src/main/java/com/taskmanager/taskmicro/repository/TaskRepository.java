package com.taskmanager.taskmicro.repository;

import com.taskmanager.taskmicro.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> getAllByUserId(Long userId, Pageable pageable);

    @Transactional
    @Query(value = "select * from task where cast(completion_date as date) = current_date",
            nativeQuery = true)
    Set<Task> getAllByUserIdAndCurrentDate(Long userId);
}
