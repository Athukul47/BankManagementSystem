package com.example.Bankmangement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.Bankmangement.payload.JwtAuthResponse;
import com.example.Bankmangement.payload.CredentialDto;
import com.example.Bankmangement.payload.UserDto;
import com.example.Bankmangement.service.AuthService;
import com.example.Bankmangement.service.UserService;

@Controller
@RequestMapping("/authorize")
public class AuthController {

	@Autowired
	private UserService userService;
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	
	//login validation 
	@PostMapping("/login")

    public ResponseEntity< JwtAuthResponse> login(@RequestBody CredentialDto credentialDto)

    {

        String token =authService.login(credentialDto);
        
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);

       

    }	
	
	
	 @PostMapping("/register")
	  public ResponseEntity<UserDto> register( @Valid @RequestBody  UserDto userDto)
	    {

	        UserDto response= userService.register(userDto);
	      
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
		 
	    }
	 
	 @PostMapping("/registeradmin")
	  public ResponseEntity<UserDto> registerAdmin( @Valid @RequestBody  UserDto userDto)
	    {

	        UserDto response= userService.registerAdmin(userDto);
	      
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
		 
	    }
	 
	 
	
}
