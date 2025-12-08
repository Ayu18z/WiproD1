package com.example.user_service.controller;

import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return service.register(u);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
        return service.login(data.get("email"), data.get("password"));
    }

    @GetMapping("/email/{id}")
    public User getEmail(@PathVariable Long id) {
        return service.getUserById(id);
    }
}

