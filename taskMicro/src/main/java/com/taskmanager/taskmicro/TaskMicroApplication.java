package com.taskmanager.taskmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = {"com.taskmanager.taskmicro"})
public class TaskMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMicroApplication.class, args);
	}

}
