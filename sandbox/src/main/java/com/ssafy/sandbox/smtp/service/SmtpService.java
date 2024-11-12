package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import com.ssafy.sandbox.smtp.dto.responseVerification;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SmtpService {
    void sendAuthMail(UserEmail userEmail) throws MessagingException;
    responseVerification verifyEmail(AuthInfo authInfo);
}