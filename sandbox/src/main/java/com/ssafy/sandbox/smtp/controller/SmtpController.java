package com.ssafy.sandbox.smtp.controller;


import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import com.ssafy.sandbox.smtp.dto.responseSendCode;
import com.ssafy.sandbox.smtp.entity.VerificationEntity;
import com.ssafy.sandbox.smtp.service.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class SmtpController {

    private final SmtpService smtpService;

    SmtpController(SmtpService smtpService) {
    this.smtpService = smtpService;
    }

    @PostMapping
    public ResponseEntity<responseSendCode> sendAutheSmtp(@RequestBody UserEmail email) {
        System.out.println("askldjfalkje");
        try {
            smtpService.sendAuthMail(email);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(responseSendCode.pass());
    }
    @PostMapping("authentication")
    public ResponseEntity<VerificationEntity> verifyAuthSmtp(@RequestBody AuthInfo authInfo) {

        return ResponseEntity.ok().build();
    }
}