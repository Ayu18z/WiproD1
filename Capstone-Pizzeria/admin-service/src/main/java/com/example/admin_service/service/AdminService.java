package com.example.admin_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.admin_service.entity.Admin;
import com.example.admin_service.exception.InvalidCredentialsException;
import com.example.admin_service.jwt.JwtUtil;
import com.example.admin_service.repo.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder encoder;

    // REGISTER ADMIN (hash password)
    public Admin createAdmin(Admin admin) {
        if (admin.getUsername() == null || admin.getPassword() == null) {
            throw new InvalidCredentialsException("Username or Password cannot be empty");
        }

        admin.setPassword(encoder.encode(admin.getPassword()));
        return repo.save(admin);
    }

    // LOGIN (throws custom exceptions)
    public Map<String, Object> login(String username, String password) {

        List<Admin> admins = repo.findByUsername(username);

        if (admins.isEmpty()) {
            throw new InvalidCredentialsException("Invalid username");
        }

        Admin admin = admins.get(0);

        if (!encoder.matches(password, admin.getPassword())) {
            throw new InvalidCredentialsException("Incorrect password");
        }

        String token = jwtUtil.generateToken(admin.getUsername(), "ADMIN");

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", admin.getUsername());
        response.put("adminId", admin.getId());
        response.put("role", "ADMIN");

        return response;
    }
}
