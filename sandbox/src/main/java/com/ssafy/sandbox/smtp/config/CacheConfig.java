package com.ssafy.sandbox.smtp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Configuration
public class CacheConfig {

    @Bean
    public HashMap<String, com.ssafy.sandbox.smtp.dto.VerificationDTO> verifications() {
        return new HashMap<>();
    }

    @Bean
    public Queue<com.ssafy.sandbox.smtp.dto.VerificationDTO> expireQueue() {
        return new LinkedList<>();
    }
}
