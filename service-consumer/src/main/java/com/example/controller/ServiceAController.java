package com.example.controller;

import com.example.feign.ServiceAFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceA")
public class ServiceAController {
    @Autowired
    private ServiceAFeignClient serviceAFeignClient;

    @GetMapping("/call")
    public String callServiceA() {
        return serviceAFeignClient.callServiceA();
    }
}