package com.ssafy.sandbox.smtp.entity;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class VerificationEntity {
    private final AuthInfo authInfo;
    private final LocalDateTime expirationTime;

    public VerificationEntity(AuthInfo authInfo) {
        this.authInfo = authInfo;
        this.expirationTime = LocalDateTime.now().plusMinutes(5);
    }
}
