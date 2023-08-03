package com.taskmanager.emailsendermicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmailSenderMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderMicroApplication.class, args);
	}

}
