package com.ssafy.sandbox.smtp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class VerificationCache {
    private final AuthInfo authInfo;
    private final LocalDateTime expirationTime;

    public VerificationCache(AuthInfo authInfo) {
        this.authInfo = authInfo;
        this.expirationTime = LocalDateTime.now().plusMinutes(5);
    }
    public String getAuthCode(){
        return this.authInfo.getAuthCode();
    }
    public String getEmail(){
        return this.authInfo.getEmail();
    }
}
