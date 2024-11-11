package com.ssafy.sandbox.smtp.controller;


import com.ssafy.sandbox.smtp.dto.responseAuthentication;
import com.ssafy.sandbox.smtp.entity.TodoListResponse;
import com.ssafy.sandbox.smtp.service.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class SmtpController {

    private SmtpService smtpService;

    @Autowired
    SmtpController(SmtpController smtpController) {
        this.smtpService = smtpService;
    }

    @PostMapping
    public ResponseEntity<responseAuthentication> sendAutheSmtp(@RequestBody String email) {
        try {
            smtpService.sendAuthMail(email);
        }catch (Exception e){
        }
        return ResponseEntity.ok().body(responseAuthentication.pass());
    }
    @PostMapping("authentication")
    public ResponseEntity<TodoListResponse> verifyAuthSmtp(@RequestBody String authentication, @RequestBody String email) {

        return ResponseEntity.ok().build();
    }
}
