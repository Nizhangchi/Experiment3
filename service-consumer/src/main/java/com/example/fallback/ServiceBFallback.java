package com.example.fallback;

import com.example.feign.ServiceBFeignClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceBFallback implements ServiceBFeignClient {
    @Override
    public String callServiceB() {
        return "Fallback response for Service B";
    }
}