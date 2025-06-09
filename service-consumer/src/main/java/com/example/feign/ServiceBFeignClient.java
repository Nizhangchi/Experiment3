package com.example.feign;

import com.example.fallback.ServiceBFallback;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b", url = "http://httpbin.org", fallback = ServiceBFallback.class)
@CircuitBreaker(name = "circuitB") // 绑定断路器实例B
public interface ServiceBFeignClient {

    @GetMapping("/status/500") // 这个接口返回500错误，用于模拟失败调用
    String callServiceB();
}