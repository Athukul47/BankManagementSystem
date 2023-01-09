package com.example.Bankmangement.service;

import com.example.Bankmangement.payload.LoginDto;
import com.example.Bankmangement.payload.RegisterDto;

public interface AuthService {
	
	String login(LoginDto loginDto);
	
	String register(RegisterDto registerDto);

	RegisterDto updateDetails(RegisterDto registerDto,long id);


}
