package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import com.ssafy.sandbox.smtp.dto.responseVerification;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpServiceImpl implements SmtpService {

    private final JavaMailSender mailSender;
    //private final SmtpRepository smtpRepository;
    private final VerifyCodeCache verifyCodeCache;
    @Value("${SPRING_SMTP_EMAIL}")
    private String senderEmail;

    @Autowired
    public SmtpServiceImpl(JavaMailSender mailSender, VerifyCodeCache verifyCodeCache) {
        this.mailSender = mailSender;
        //this.smtpRepository = smtpRepository;
        this.verifyCodeCache = verifyCodeCache;
    }

    public String createAuthNum(){
        Double num = Math.random();
        String code = String.valueOf(num.toString().hashCode());
        return code.substring(0, 6);
    }
    private MimeMessage setMail(AuthInfo authInfo) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(senderEmail);
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(authInfo.getEmail()));
        message.setText(authInfo.getAuthCode(), "UTF-8","html");
        return message;
    }

    public void sendAuthMail(UserEmail userEmail) throws MessagingException {
        String AuthNumber = createAuthNum();
        AuthInfo authInfo = new AuthInfo(userEmail, AuthNumber);
        MimeMessage verificaitonMessage = setMail(authInfo);
        verifyCodeCache.CreateVerification(authInfo);
        mailSender.send(verificaitonMessage);
    }

    @Override
    public responseVerification verifyEmail(AuthInfo authInfo) {
        if(verifyCodeCache.doVerify(authInfo)) return responseVerification.pass();
        else return responseVerification.fail();
    }
}
