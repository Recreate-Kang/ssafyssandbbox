package com.ssafy.sandbox.smtp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VerificationDTO {
    private final AuthInfo authInfo;
    private final LocalDateTime expirationTime;

    public VerificationDTO(AuthInfo authInfo) {
        this.authInfo = authInfo;
        this.expirationTime = LocalDateTime.now().plusMinutes(5);
    }
}
