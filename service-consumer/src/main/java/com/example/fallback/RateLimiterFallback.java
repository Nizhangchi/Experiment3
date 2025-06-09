package com.example.fallback;

import org.springframework.stereotype.Component;

@Component
public class RateLimiterFallback {
    public String fallback(Throwable t) {
        return "Rate Limit Fallback: Too many requests, please slow down";
    }
}