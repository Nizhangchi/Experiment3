package com.example.controller;

import com.example.feign.ServiceAFeignClient;
import com.example.feign.ServiceBFeignClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class DemoController {
    @Autowired
    private ServiceAFeignClient serviceA;

    @Autowired
    private ServiceBFeignClient serviceB;

    @Value("${server.port}")
    private String port;

    @GetMapping("/consumer/callA")
    @CircuitBreaker(name = "circuitA", fallbackMethod = "fallbackA")
    @Bulkhead(name = "bulkheadA", fallbackMethod = "bulkheadFallbackA")
    @RateLimiter(name = "rateLimiterA", fallbackMethod = "rateLimitFallbackA")
    public String callA() {
        return serviceA.callServiceA() + "Service A Response from port: " + port;
    }
    @GetMapping("/consumer/callB")
    @CircuitBreaker(name = "circuitB", fallbackMethod = "fallbackB")
    public String callB() {
        return serviceB.callServiceB();
    }

    // 降级方法
    public String fallbackA(Throwable t) {
        return "CircuitBreaker Fallback for Service A";
    }
    public String fallbackB(Throwable t) {
        return "CircuitBreaker Fallback for Service B";
    }
    public String bulkheadFallbackA(Throwable t) {
        return "Bulkhead Fallback: System busy!";
    }
    public String rateLimitFallbackA(Throwable t) {
        return "RateLimit Fallback: Too many requests!";
    }
}