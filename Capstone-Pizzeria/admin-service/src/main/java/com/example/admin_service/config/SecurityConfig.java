package com.example.admin_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.admin_service.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // allow frontend static HTML/CSS/JS
                .requestMatchers(
                        "/admin-login.html",
                        "/admin-home.html",
                        "/admin-menu.html",
                        "/admin-orders.html",
                        "/admin-revenue.html",
                        "/style.css",
                        "/app.js"
                ).permitAll()

                // allow login and register
                .requestMatchers("/admin/login", "/admin/createadmin").permitAll()

                // backend API RBAC protection
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // everything else needs authentication
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
