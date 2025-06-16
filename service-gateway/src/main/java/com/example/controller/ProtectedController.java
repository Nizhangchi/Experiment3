package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedController {

    @GetMapping("/protected/callB")
    public String callB() {
        // 模拟50%失败率
        if (Math.random() > 0.5) {
            throw new RuntimeException("Service failure");
        }
        return "Success response";
    }
}
