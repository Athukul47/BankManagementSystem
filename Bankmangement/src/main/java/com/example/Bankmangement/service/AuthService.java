package com.example.Bankmangement.service;

import com.example.bankmangement.payload.CredentialDto;


public interface AuthService {
	
	String login(CredentialDto credentialDto);
	
	

}
