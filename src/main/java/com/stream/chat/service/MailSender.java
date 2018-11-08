package com.stream.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;


    public void send(String emailTo, String subject, String message){
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mailMessage, true);


            helper.setFrom(username);
            helper.setTo(emailTo);
            helper.setSubject(subject);
            //helper.setText(message);

            mailMessage.setContent(message, "text/html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mailMessage);
    }
}
