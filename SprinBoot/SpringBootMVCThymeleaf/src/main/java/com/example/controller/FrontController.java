package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.UserService;

@Controller
public class FrontController {

    @Autowired
    private UserService userService;

    // 1. Home Page
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    // 2. Login Page
    @GetMapping("/log")
    public String showLoginPage() {
        return "login";
    }

    // 3. Register Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // 4. User Registration POST
    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        User user = new User(username, password);
        String result = userService.registerUser(user);

        if (result.equals("User registered successfully!")) {
            return "redirect:/log";
        } else {
            model.addAttribute("message", result);
            return "register";
        }
    }
}
