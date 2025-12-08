package com.example.admin_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.admin_service.entity.Admin;
import com.example.admin_service.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*") // allow frontend fetch during development
public class AdminController {

    @Autowired
    public AdminService service;

    @PostMapping("/createadmin")
    public Admin createAdmin(@RequestBody Admin a) {
        return service.createAdmin(a);
    }

    /**
     * Expects JSON like { "username": "...", "password": "..." }
     * Returns map with token, username, adminId
     */
    
    
    
//    @PostMapping("/login")
//    public Map<String, Object> adminLogin(@RequestBody Map<String, String> data) {
//        return service.login(data.get("username"), data.get("password"));
//    }
//    
    
    
    @PostMapping("/login")
    public Map<String, Object> adminLogin(@RequestBody Map<String, String> data) {

        System.out.println("Incoming JSON: " + data);  

        return service.login(data.get("username"), data.get("password"));
    }

}
