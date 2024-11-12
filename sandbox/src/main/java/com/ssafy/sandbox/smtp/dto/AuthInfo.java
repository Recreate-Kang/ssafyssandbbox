package com.ssafy.sandbox.smtp.dto;

import lombok.Data;

@Data
public class AuthInfo {

    String authCode;
    String email;

    public AuthInfo(UserEmail email, String authNumber){
        this.email = email.getEmail();
        this.authCode = authNumber;
    }
}
