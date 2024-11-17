package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Queue;

@Component
public class VerifyCodeCache {
    private final HashMap<String, com.ssafy.sandbox.smtp.dto.VerificationDTO> verifications;
    private final Queue<com.ssafy.sandbox.smtp.dto.VerificationDTO> expireQueue;

    @Autowired
    public VerifyCodeCache(HashMap<String, com.ssafy.sandbox.smtp.dto.VerificationDTO> verifications,
                           Queue<com.ssafy.sandbox.smtp.dto.VerificationDTO> expireQueue) {
        this.verifications = verifications;
        this.expireQueue = expireQueue;
    }

    public void CreateVerification(AuthInfo authInfo) {
        deleteExpiredVerifications();
        com.ssafy.sandbox.smtp.dto.VerificationDTO newVerificiationInfo = new com.ssafy.sandbox.smtp.dto.VerificationDTO(authInfo);
        verifications.put(newVerificiationInfo.getAuthInfo().getAuthCode(), newVerificiationInfo);
        expireQueue.add(newVerificiationInfo);
    }

    public boolean doVerify(AuthInfo authInfo) {
        deleteExpiredVerifications();
        com.ssafy.sandbox.smtp.dto.VerificationDTO verificationEntity = verifications.get(authInfo.getAuthCode());
        if (verificationEntity == null) return false;
        if (verificationEntity.getExpirationTime().isBefore(LocalDateTime.now())) return false;
        if (!verificationEntity.getAuthInfo().getEmail().equals(authInfo.getEmail())) return false;
        if (!verificationEntity.getAuthInfo().getAuthCode().equals(authInfo.getAuthCode())) return false;
        return true;
    }

    public void deleteExpiredVerifications() {
        while (!expireQueue.isEmpty() && !expireQueue.peek().getExpirationTime().isAfter(LocalDateTime.now())) {
            verifications.remove(expireQueue.poll().getAuthInfo().getAuthCode());
        }
    }
}
