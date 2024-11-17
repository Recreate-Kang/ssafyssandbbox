package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface SmtpService {
    void sendAuthMail(UserEmail userEmail) throws MessagingException;

    com.ssafy.sandbox.smtp.dto.ResponseVerification verifyEmail(AuthInfo authInfo);
}