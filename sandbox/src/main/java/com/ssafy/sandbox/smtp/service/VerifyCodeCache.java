package com.ssafy.sandbox.smtp.service;

import com.ssafy.sandbox.smtp.dto.AuthInfo;
import com.ssafy.sandbox.smtp.dto.VerificationCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Queue;

@Component
public class VerifyCodeCache {
    private final HashMap<String, VerificationCache> verifications;
    private final Queue<VerificationCache> expireQueue;

    @Autowired
    public VerifyCodeCache(HashMap<String, VerificationCache> verifications, Queue<VerificationCache> expireQueue) {
        this.verifications = verifications;
        this.expireQueue = expireQueue;
    }

    public void CreateVerification(AuthInfo authInfo) {
        deleteExpiredVerifications();
        VerificationCache newVerificiationInfo = new VerificationCache(authInfo);
        verifications.put(newVerificiationInfo.getAuthCode(), newVerificiationInfo);
        expireQueue.add(newVerificiationInfo);
    }

    public boolean doVerify(AuthInfo authInfo) {
        deleteExpiredVerifications();
        VerificationCache verificationCache = verifications.get(authInfo.getAuthCode());
        if (verificationCache == null) return false;
        if (!verificationCache.getEmail().equals(authInfo.getEmail())) return false;
        if (verificationCache.getAuthCode().equals(authInfo.getAuthCode())) return false;
        return true;
    }

    public void deleteExpiredVerifications() {
        while (!expireQueue.isEmpty() && !expireQueue.peek().getExpirationTime().isAfter(LocalDateTime.now())) {
            verifications.remove(expireQueue.poll().getAuthCode());
        }
    }
}
