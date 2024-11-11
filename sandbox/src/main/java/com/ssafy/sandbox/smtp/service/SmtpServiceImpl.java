package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.entity.VerifyCodeCache;
import com.ssafy.sandbox.smtp.repository.SmtpRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.cglib.core.HashCodeCustomizer;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SmtpServiceImpl implements SmtpService {

    private final JavaMailSender mailSender;
    private final SmtpRepository smtpRepository;
    private final VerifyCodeCache verifyCodeCache;
    @Value("${SPRING_SMTP_EMAIL}")
    private String senderEmail;

    @Autowired
    public SmtpServiceImpl(JavaMailSender mailSender, SmtpRepository smtpRepository) {
        this.mailSender = mailSender;
        this.smtpRepository = smtpRepository;
    }

    public String createAuthNum(){

        Double num = Math.random();
        String code = String.valueOf(num.toString().hashCode());
        return code.substring(0, 6);
    }
    public String sendAuthMail(String userEmail) throws MessagingException {
        String number = createAuthNum();
        MimeMessage authMail = setMail(userEmail, number);
        try{
            mailSender.send(authMail);
        }catch(MailException e){
            e.printStackTrace();
        }
        return null;
    }
    private MimeMessage setMail(String userEmail, String number) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(senderEmail);
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(userEmail));
        message.setText(number, "UTF-8","html");
        return message;
    }


}
