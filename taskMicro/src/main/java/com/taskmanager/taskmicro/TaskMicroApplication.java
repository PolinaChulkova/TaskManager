package com.taskmanager.taskmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.taskmicro"})
@EnableJpaRepositories(basePackages = {"com.taskmanager.taskmicro"})
@EntityScan(basePackages = {"com.taskmicro.entity"})
public class TaskMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMicroApplication.class, args);
	}

}
