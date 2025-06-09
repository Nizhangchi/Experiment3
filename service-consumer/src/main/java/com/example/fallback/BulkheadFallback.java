package com.example.fallback;

import org.springframework.stereotype.Component;

@Component
public class BulkheadFallback {
    public String fallback(Throwable t) {
        return "Bulkhead Fallback: System busy, try again later";
    }
}