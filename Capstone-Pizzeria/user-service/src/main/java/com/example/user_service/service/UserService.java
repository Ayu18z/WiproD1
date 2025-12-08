package com.example.user_service.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user_service.entity.User;
import com.example.user_service.exception.InvalidInputException;
import com.example.user_service.exception.ResourceNotFoundException;
import com.example.user_service.jwt.JwtUtil;
import com.example.user_service.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public User register(User u) {

        if (u.getEmail() == null || u.getUsername() == null || u.getPassword() == null) {
            throw new InvalidInputException("All fields (username, email, password) are required");
        }

        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return repo.save(u);
    }
    
    
    

 //login with excpt   
    public Map<String, Object> login(String email, String rawPassword) {

        if (email == null || rawPassword == null) {
            throw new InvalidInputException("Email and password cannot be empty");
        }

        User u = repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        if (!passwordEncoder.matches(rawPassword, u.getPassword())) {
            throw new InvalidInputException("Incorrect password");
        }

        String token = jwtUtil.generateToken(u.getEmail(), "USER");

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", u.getUsername());
        response.put("userId", u.getId());
        response.put("role", "USER");

        return response;
    }
    //email not found
    
    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    
    

}
