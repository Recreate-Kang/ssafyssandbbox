package com.ssafy.sandbox.smtp.config;
import com.ssafy.sandbox.smtp.dto.VerificationCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Configuration
public class CacheConfig {

    @Bean
    public HashMap<String, VerificationCache> verifications() {
        return new HashMap<>();
    }

    @Bean
    public Queue<VerificationCache> expireQueue() {
        return new LinkedList<>();
    }
}
