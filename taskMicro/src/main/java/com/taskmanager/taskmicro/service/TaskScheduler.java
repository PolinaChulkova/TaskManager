package com.taskmanager.taskmicro.service;

import com.taskmanager.taskmicro.dto.Email;
import com.taskmanager.taskmicro.dto.UserInfoDto;
import com.taskmanager.taskmicro.entity.Task;
import com.taskmanager.taskmicro.mq.MessageFuncAction;
import com.taskmanager.taskmicro.repository.TaskRepository;
import com.taskmanager.taskmicro.webclient.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.Set;
import java.util.stream.Collectors;

@EnableScheduling
@RequiredArgsConstructor
public class TaskScheduler {

    private final MessageFuncAction messageFuncAction;
    private final TaskRepository taskRepository;
    private final UserClient userClient;

    @Scheduled(cron = "@midnight")
    public void sendTasks() {
        userClient.getAllUsersInfo().stream().map(this::createEmailForUser)
                .forEach(messageFuncAction::sendEmail);
    }

    private Email createEmailForUser(UserInfoDto userInfoDto) {
        Set<Task> tasks = taskRepository.getAllByUserIdAndCompletionDate(userInfoDto.getUserId(), Calendar.getInstance());

        Set<String> completed = tasks.stream().filter(Task::getStatus)
                .map(Task::getTitle).collect(Collectors.toSet());
        Set<String> uncompleted = tasks.stream().limit(5).filter(t -> !t.getStatus())
                .map(Task::getTitle).collect(Collectors.toSet());

        return new Email(
                userInfoDto.getEmail(),
                String.format(
                        "Выполнено %d задач за сутки:\n%s.\nНе выполнено %d задач за сутки:\n%s.",
                        completed.size(),
                        String.join(",\n", completed),
                        uncompleted.size(),
                        String.join(",\n", completed))
        );
    }
}
