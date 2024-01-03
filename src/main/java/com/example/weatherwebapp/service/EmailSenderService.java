package com.example.weatherwebapp.service;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String prepareMessage);

    void sendVerificationMail(String to);

}
