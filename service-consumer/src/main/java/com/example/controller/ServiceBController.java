package com.example.controller;

import com.example.feign.ServiceBFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class ServiceBController {
    @Autowired
    private ServiceBFeignClient serviceBFeignClient;

    @GetMapping("/call")
    public String callServiceB() {
        return serviceBFeignClient.callServiceB();
    }
}
