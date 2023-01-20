package com.example.Bankmangement.controller;

import javax.validation.Valid;

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
import com.example.Bankmangement.payload.LoginDto;
import com.example.Bankmangement.payload.RegisterDto;
import com.example.Bankmangement.service.AuthService;

@Controller
@RequestMapping("/authorize")
public class AuthController {

	
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	
	//login validation 
	@PostMapping("/login")

    public ResponseEntity< JwtAuthResponse> login(@RequestBody LoginDto loginDto)

    {

        String token =authService.login(loginDto);
        
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);

       

    }	
	
	
	 @PostMapping("/register")
	  public ResponseEntity<RegisterDto> register( @Valid @RequestBody  RegisterDto registerDto)
	    {

	        RegisterDto response= authService.register(registerDto); 
	      
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
		 
	    }
	 
	 @PostMapping("/registeradmin")
	  public ResponseEntity<String> registerAdmin( @Valid @RequestBody  RegisterDto registerDto)
	    {

	        String response= authService.registerAdmin(registerDto); 
	      
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
		 
	    }
	 
	 
	
}
