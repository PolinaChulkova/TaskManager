package com.taskmanager.taskmicro.repository;

import com.taskmanager.taskmicro.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> getAllByUserId(Long userId, Pageable pageable);

    @Query(value = "select * from task where cast(planned_due_date as date) = current_date " +
            "and user_id = :userId",
            nativeQuery = true)
    Set<Task> getAllByUserIdAndCurrentDate(@Param("userId") long userId);

    int countAllByUserId(long userId);

    int countAllByUserIdAndStatus(long userId, boolean status);

    @Query(value = "select count(t) from Task t where t.userId = :userId and extract(year from t.plannedDueDate) = :year " +
            "and extract(month from t.plannedDueDate) = :month")
    int countAllByUserIdAndMonth(@Param("userId") long userId,
                                 @Param("year") int year,
                                 @Param("month") int month);

    @Query(value = "select count(t) from Task t where t.userId = :userId and extract(year from t.plannedDueDate) = :year " +
            "and extract(month from t.plannedDueDate) = :month and t.status = :status")
    int countTasksByUserIdAndMonthAndStatus(@Param("userId") long userId,
                                            @Param("year") int year,
                                            @Param("month") int month,
                                            @Param("status") boolean status);

    @Query(value = "select distinct extract(YEAR from planned_due_date ) from task", nativeQuery = true)
    List<Integer> getAllYearsTasksByUserId(@Param("userId") long userId);

}
