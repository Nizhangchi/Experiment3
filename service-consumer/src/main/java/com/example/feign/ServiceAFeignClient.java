package com.example.feign;

import com.example.fallback.ServiceAFallback;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-a", url = "http://httpbin.org", fallback = ServiceAFallback.class)
@CircuitBreaker(name = "circuitA") // 绑定断路器实例A
public interface ServiceAFeignClient {

    @GetMapping("/delay/3") // 这个接口会延迟3秒，用于模拟慢调用
    String callServiceA();
}