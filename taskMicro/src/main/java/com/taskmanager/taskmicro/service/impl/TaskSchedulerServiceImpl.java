package com.taskmanager.taskmicro.service.impl;

import com.taskmanager.taskmicro.dto.EmailDto;
import com.taskmanager.taskmicro.dto.UserInfoDto;
import com.taskmanager.taskmicro.entity.Task;
import com.taskmanager.taskmicro.mq.MessageFuncAction;
import com.taskmanager.taskmicro.repository.TaskRepository;
import com.taskmanager.taskmicro.service.TaskScheduleService;
import com.taskmanager.taskmicro.webclient.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskSchedulerServiceImpl implements TaskScheduleService {

    private final MessageFuncAction messageFuncAction;
    private final TaskRepository taskRepository;
    private final UserClient userClient;

    @Override
//    @Scheduled(cron = "@midnight")
    @Scheduled(fixedRate = 10000)
    public void sendEmail() {
        userClient.getAllUsersInfo().stream().map(this::createEmailForUser)
                .forEach(messageFuncAction::sendEmail);

    }

    private EmailDto createEmailForUser(UserInfoDto userInfoDto) {
        Set<Task> tasks = taskRepository.getAllByUserIdAndCurrentDate(userInfoDto.getUserId());

        Set<String> completed = tasks.stream().filter(Task::getStatus)
                .map(Task::getTitle).collect(Collectors.toSet());
        log.info("Выполненные задания: " + completed.toString());
        Set<String> uncompleted = tasks.stream().limit(5).filter(t -> !t.getStatus())
                .map(Task::getTitle).collect(Collectors.toSet());
        log.info("Не выполненные задания: " + uncompleted);

        return new EmailDto(
                userInfoDto.getEmail(),
                String.format(
                        "Выполнено %d задач за сутки:\n%s\nНе выполнено %d задач за сутки:\n%s",
                        completed.size(),
                        String.join(",\n", completed),
                        uncompleted.size(),
                        String.join(",\n", completed))
        );
    }
}
