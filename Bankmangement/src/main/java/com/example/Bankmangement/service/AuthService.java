package com.example.Bankmangement.service;

import com.example.Bankmangement.payload.CredentialDto;
import com.example.Bankmangement.payload.UserDto;

public interface AuthService {
	
	String login(CredentialDto credentialDto);
	
	UserDto register(UserDto userDto);

	
	UserDto registerAdmin(UserDto userDto);


}
