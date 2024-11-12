package com.ssafy.sandbox.smtp.controller;


import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.UserEmail;
import com.ssafy.sandbox.smtp.dto.responseSendCode;
import com.ssafy.sandbox.smtp.dto.responseVerification;
import com.ssafy.sandbox.smtp.service.SmtpService;
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
        try {
            smtpService.sendAuthMail(email);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(responseSendCode.pass());
    }
    @PostMapping("/authentication")
    public ResponseEntity<responseVerification> verifyAuthSmtp(@RequestBody AuthInfo authInfo) {
        return ResponseEntity.ok().body(smtpService.verifyEmail(authInfo));
    }
}
