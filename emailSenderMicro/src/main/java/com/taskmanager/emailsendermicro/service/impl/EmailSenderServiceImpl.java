package com.taskmanager.emailsendermicro.service.impl;

import com.taskmanager.emailsendermicro.dto.EmailDto;
import com.taskmanager.emailsendermicro.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderServiceImpl implements EmailSenderService {

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    @Override
    public void sendEmail(EmailDto emailDto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(emailDto.getTo());
            mailMessage.setSubject(emailDto.getSubject());
            mailMessage.setText(emailDto.getText());
            emailSender.send(mailMessage);
            log.info("EmailDto отправлен на почту " + emailDto.getTo());
        } catch (MailException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Не удалось отправить сообщение на email: " + emailDto.getTo());
        }
    }
}
