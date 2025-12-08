package com.example.order.feign;

import com.example.order.dto.UserEmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user/email/{id}")
    UserEmailDTO getUserById(@PathVariable("id") Long id);
}
