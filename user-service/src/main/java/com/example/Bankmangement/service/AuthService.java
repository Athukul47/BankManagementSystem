package com.example.Bankmangement.service;

import com.example.Bankmangement.payload.CredentialDto;


public interface AuthService {
	
	String login(CredentialDto credentialDto);
	
	

}
