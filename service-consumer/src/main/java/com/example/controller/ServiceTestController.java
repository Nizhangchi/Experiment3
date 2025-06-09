package com.example.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ServiceTestController {

    @Bulkhead(name = "bulkheadA", fallbackMethod = "bulkheadFallback")
    @RateLimiter(name = "rateLimiterA", fallbackMethod = "rateLimitFallback")
    @GetMapping("/protected")
    public String protectedResource() {
        // 模拟资源处理
        return "Resource accessed successfully";
    }

    public String bulkheadFallback(Throwable t) {
        return "Bulkhead Fallback: System overloaded!";
    }

    public String rateLimitFallback(Throwable t) {
        return "Rate Limit Fallback: Too many requests!";
    }
}