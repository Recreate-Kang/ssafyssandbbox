package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.crud.vo.Todo;
import com.ssafy.sandbox.crud.dto.TodoListResponse;
import com.ssafy.sandbox.crud.repository.TodoRepository;
import com.ssafy.sandbox.smtp.repository.SmtpRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SmtpService {



    public String sendAuthMail(String userEmail) throws MessagingException;

}