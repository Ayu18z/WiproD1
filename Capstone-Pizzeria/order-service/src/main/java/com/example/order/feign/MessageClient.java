package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "message-service")
public interface MessageClient {

    @PostMapping("/message/send")
    String sendMessage(@RequestBody Map<String, Object> body);
}
