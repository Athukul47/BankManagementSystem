package com.example.Bankmangement.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.Bankmangement.payload.JwtAuthResponse;
import com.example.Bankmangement.payload.LoginDto;
import com.example.Bankmangement.payload.RegisterDto;
import com.example.Bankmangement.service.AuthService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {
    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private LoginDto loginDto;
    private RegisterDto registerDto;
    private JwtAuthResponse jwtAuthResponse;

    @Before
    public void setUp() {
        loginDto = new LoginDto();
        registerDto = new RegisterDto();
        jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken("test_token");
    }

    @Test
    public void login_validInput() {
        when(authService.login(any(LoginDto.class))).thenReturn("test_token");
        ResponseEntity<JwtAuthResponse> response = authController.login(loginDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("test_token", response.getBody().getAccessToken());
    }

    @Test
    public void register_validInput() {
        when(authService.register(any(RegisterDto.class))).thenReturn(registerDto);
        ResponseEntity<RegisterDto> response = authController.register(registerDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(registerDto, response.getBody());
    }
    
    @Test
    public void registerAdmin_validInput() {
        when(authService.registerAdmin(any(RegisterDto.class))).thenReturn("Success");
        ResponseEntity<String> response = authController.registerAdmin(registerDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Success", response.getBody());
    }
}
