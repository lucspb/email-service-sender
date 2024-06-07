package com.lucspb.email.services;

import com.lucspb.email.entities.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Email email) {
        var message = new SimpleMailMessage();
        message.setFrom("noreply@teste.com");
        message.setTo(email.destinatario());
        message.setSubject(email.assunto());
        message.setText(email.messagem());
        mailSender.send(message);
    }
}
