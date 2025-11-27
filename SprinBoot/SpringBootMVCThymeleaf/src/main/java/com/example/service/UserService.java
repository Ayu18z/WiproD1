package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Business Logic → Check + Save User
    public String registerUser(User user) {
        if (userRepository.userExists(user.getUsername())) {
            return "Username already exists!";
        }
        userRepository.saveUser(user);
        return "User registered successfully!";
    }
}
