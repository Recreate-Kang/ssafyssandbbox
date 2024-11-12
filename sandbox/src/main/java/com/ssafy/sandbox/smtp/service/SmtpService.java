package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.UserEmail;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SmtpService {



    public void sendAuthMail(UserEmail userEmail) throws MessagingException;

}