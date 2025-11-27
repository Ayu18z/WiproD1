package com.example.SpringSecurityFromJDBC.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityFromJDBC.entity.AppUser;
import com.example.SpringSecurityFromJDBC.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
	
	private final UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser user = repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found: " + username));
		return new User( 
						user.getUsername(),
						user.getPassword(),
						List.of(new SimpleGrantedAuthority(user.getRole()))
								
						);
	}

}