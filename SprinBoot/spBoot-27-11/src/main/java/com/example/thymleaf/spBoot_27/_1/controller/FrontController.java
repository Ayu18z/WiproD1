package com.example.thymleaf.spBoot_27._1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    // Home page
    @GetMapping("/")
    public String homePage() {
        return "home";   // maps to home.html
    }

    // Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // maps to login.html
    }

    // Register page
    @GetMapping("/register")
    public String registerPage() {
        return "register";  // maps to register.html
    }
}
