package com.ssafy.sandbox.smtp.controller;


import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import com.ssafy.sandbox.smtp.service.SmtpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class SmtpController {

    private final SmtpService smtpService;

    SmtpController(SmtpService smtpService) {
        this.smtpService = smtpService;
    }

    @PostMapping
    public ResponseEntity<com.ssafy.sandbox.smtp.dto.ResponseSendCode> sendAutheSmtp(@RequestBody UserEmail email) throws Exception {
        smtpService.sendAuthMail(email);
        return ResponseEntity.ok().body(com.ssafy.sandbox.smtp.dto.ResponseSendCode.pass());
    }

    @PostMapping("/authentication")
    public ResponseEntity<com.ssafy.sandbox.smtp.dto.ResponseVerification> verifyAuthSmtp(@RequestBody AuthInfo authInfo) {
        return ResponseEntity.ok().body(smtpService.verifyEmail(authInfo));
    }
}
