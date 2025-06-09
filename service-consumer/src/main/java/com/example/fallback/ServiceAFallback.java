package com.example.fallback;

import com.example.feign.ServiceAFeignClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceAFallback implements ServiceAFeignClient {
    @Override
    public String callServiceA() {
        return "Fallback response for Service A";
    }
}