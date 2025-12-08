package com.example.order.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.order.dto.MenuItemDTO;

@FeignClient(
    name = "menu-service",
    url = "http://localhost:8083"
)
public interface MenuClient {

    @GetMapping("/menu/all")
    List<MenuItemDTO> getAllMenuItems();
}
