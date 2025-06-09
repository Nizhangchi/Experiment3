package com.example.config;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public CircuitBreaker circuitBreaker() {
        return CircuitBreaker.of("feign-circuitbreaker", CircuitBreakerConfig.ofDefaults());
    }

    @Bean
    public Bulkhead bulkhead() {
        return Bulkhead.of("feign-bulkhead", BulkheadConfig.ofDefaults());
    }

    @Bean
    public RateLimiter rateLimiter() {
        return RateLimiter.of("feign-ratelimiter", RateLimiterConfig.ofDefaults());
    }
}