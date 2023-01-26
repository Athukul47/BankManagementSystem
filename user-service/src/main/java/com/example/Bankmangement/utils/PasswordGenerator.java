package com.example.Bankmangement.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {
	
	public static void main(String[] args)
	{
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		
	}

}
