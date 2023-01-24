package com.example.Bankmangement.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Bankmangement.entity.Role;
import com.example.Bankmangement.entity.User;
import com.example.Bankmangement.exception.LoanApiException;
import com.example.Bankmangement.payload.CredentialDto;
import com.example.Bankmangement.payload.UserDto;
import com.example.Bankmangement.repository.RoleRepository;
import com.example.Bankmangement.repository.UserRepository;
import com.example.Bankmangement.security.JwtTokenProvider;
import com.example.Bankmangement.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager ,UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider		) {
		this.authenticationManager = authenticationManager;
		this.userRepository=userRepository;
		this.roleRepository=roleRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtTokenProvider= jwtTokenProvider;
	}

	@Override
	public String login(CredentialDto credentialDto) {
	

	Authentication authentication=	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentialDto.getUsername(),credentialDto.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);	
	
	String token = jwtTokenProvider.generateToken(authentication);

  return token ;
	}

	
	}


