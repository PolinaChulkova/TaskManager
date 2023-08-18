package com.taskmanager.taskmicro.service;

import com.taskmanager.taskmicro.entity.Task;
import com.taskmanager.taskmicro.repository.TaskRepository;
import com.taskmanager.taskmicro.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    private final TaskService taskService;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.taskService = new TaskServiceImpl(taskRepository);
    }

    @Test
    public void getTasksByUserId() {
        Task task1 = new Task(
                1L, "Task1", "Description",
                true,
                LocalDate.of(2023, 9, 15),
                1L);
        Task task2 = new Task(
                1L, "Task2", "Description",
                true,
                LocalDate.of(2023, 9, 15),
                1L);

        given(taskRepository.getAllByUserId(1L, PageRequest.of(0, 2)))
                .willReturn(new PageImpl<Task>(List.of(task1, task2)));

        Page<Task> page = taskService.getTasksByUserId(1L, PageRequest.of(0, 2));

        assertEquals(new PageImpl<Task>(List.of(task1, task2)).getContent(), page.getContent());
    }

    @Test
    public void deleteTaskByTaskId() {
        Task task1 = new Task(
                1L, "Task1", "Description",
                true,
                LocalDate.of(2023, 9, 15),
                1L);

        when(taskRepository.findById(task1.getTaskId())).thenReturn(Optional.of(task1));
        taskService.deleteTaskByTaskId(task1.getTaskId());
        verify(taskRepository, times(1)).deleteById(task1.getTaskId());

        ArgumentCaptor<Long> taskArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(taskRepository).deleteById(taskArgumentCaptor.capture());

        Long taskIdDeleted = taskArgumentCaptor.getValue();
        assertNotNull(taskIdDeleted);
        assertEquals(1L, taskIdDeleted);
    }

    @Test
    public void createTask() {
        Task task1 = new Task(
                1L, "Task1", "Description",
                true,
                LocalDate.of(2023, 9, 15),
                1L);

        taskService.createTask(task1);
        verify(taskRepository, times(1)).save(task1);
        ArgumentCaptor<Task> argumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository).save(argumentCaptor.capture());
        Task taskCreated = argumentCaptor.getValue();

        assertNotNull(taskCreated.getTaskId());
        assertEquals("Task1", taskCreated.getTitle());
    }

//    @Test
//    public void updateTaskByFields() {
//        Task task1 = new Task(
//                1L, "Task1", "Description",
//                true,
//                new GregorianCalendar(2023, Calendar.OCTOBER, 15, 20, 0),
//                1L);
//
//        Map<String, Object> fields = Map.of("title", "TaskTitle", "status", false);
//
//        given(taskRepository.save(task1)).willReturn(task1);
//        task1.setTitle("TaskTitle");
//        task1.setStatus(false);
//        Task updateTask = taskService.updateTaskByFields(task1.getTaskId(), fields);
//
//        assertEquals(updateTask.getTitle(), "TaskTitle");
//        assertEquals(updateTask.getStatus(), false);
//    }
}
