package com.ssafy.sandbox.smtp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthInfo {
    @JsonProperty("authentication")
    String authCode;
    String email;

    public AuthInfo(UserEmail email, String authNumber) {
        this.email = email.getEmail();
        this.authCode = authNumber;
    }
}
