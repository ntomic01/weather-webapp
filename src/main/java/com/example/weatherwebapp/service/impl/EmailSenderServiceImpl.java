package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.service.EmailSenderService;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("nidzatomic01@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendVerificationMail(String to) {
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            // <a href='http://localhost:8080/authorize/verifyAccount?email=igor@gmail.com'>here</a>
            String redirectLink = "<a href='"+"http://localhost:8080/authorize/verifyAccount?email="+to+"'>here</a>";
            mimeMailMessage.setContent("Click "+redirectLink+" to verify your account.", "text/html");
            mimeMailMessage.setFrom(new InternetAddress("nidzatomic01@gmail.com"));
            mimeMailMessage.setSubject("Verify your account");
            mimeMailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mailSender.send(mimeMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
