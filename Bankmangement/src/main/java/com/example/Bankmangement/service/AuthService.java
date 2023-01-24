package com.example.Bankmangement.service;

import com.example.Bankmangement.payload.CredentialDto;
import com.example.Bankmangement.payload.UserDto;

public interface AuthService {
	
	String login(CredentialDto credentialDto);
	
	

}
