package com.example.SpringSecurityFromJDBC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurityFromJDBC.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser , Long> {
	
	Optional<AppUser> findByUsername(String username);  // when it will return a boolean so return type will be Optional

}