package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpServiceImpl implements SmtpService {

    private final JavaMailSender mailSender;
    private final VerifyCodeCache verifyCodeCache;
    @Value("${SPRING_SMTP_EMAIL}")
    private String senderEmail;

    public SmtpServiceImpl(JavaMailSender mailSender, VerifyCodeCache verifyCodeCache) {
        this.mailSender = mailSender;
        //this.smtpRepository = smtpRepository;
        this.verifyCodeCache = verifyCodeCache;
    }

    public String createAuthNum() {
        Double num = Math.random();
        String code = String.valueOf(num.toString().hashCode());
        return code.substring(0, 6);
    }

    private MimeMessage setMail(AuthInfo authInfo) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(senderEmail);
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(authInfo.getEmail()));
        message.setText(authInfo.getAuthCode(), "UTF-8", "html");
        return message;
    }

    @Override
    public void sendAuthMail(UserEmail userEmail) throws MessagingException {
        String AuthNumber = createAuthNum();
        AuthInfo authInfo = new AuthInfo(userEmail, AuthNumber);
        MimeMessage verificaitonMessage = setMail(authInfo);
        verifyCodeCache.CreateVerification(authInfo);
        mailSender.send(verificaitonMessage);
    }

    @Override
    public com.ssafy.sandbox.smtp.dto.ResponseVerification verifyEmail(AuthInfo authInfo) {
        if (verifyCodeCache.doVerify(authInfo)) return com.ssafy.sandbox.smtp.dto.ResponseVerification.pass();
        else return com.ssafy.sandbox.smtp.dto.ResponseVerification.fail();
    }
}
