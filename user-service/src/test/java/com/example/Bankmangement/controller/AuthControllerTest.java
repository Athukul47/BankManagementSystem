package com.example.Bankmangement.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Bankmangement.payload.JwtAuthResponse;
import com.example.Bankmangement.payload.CredentialDto;
import com.example.Bankmangement.payload.UserDto;
import com.example.Bankmangement.service.AuthService;
import com.example.Bankmangement.service.UserService;

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
    private UserService userService;
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private CredentialDto credentialDto;
    private UserDto userDto;
    private JwtAuthResponse jwtAuthResponse;

    @Before
    public void setUp() {
        credentialDto= new CredentialDto();
        userDto = new UserDto();
        jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken("test_token");
    }

    @Test
    public void login_validInput() {
        when(authService.login(any(CredentialDto.class))).thenReturn("test_token");
        ResponseEntity<JwtAuthResponse> response = authController.login(credentialDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("test_token", response.getBody().getAccessToken());
        
        verify(authService).login(credentialDto);
       
    }

    @Test
    public void register_validInput() {
        when(userService.register(any(UserDto.class))).thenReturn(userDto);
        ResponseEntity<UserDto> response = authController.register(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService,times(1)).register(userDto);
    }
    
    @Test
    public void registerAdmin_validInput() {
        when(userService.registerAdmin(any(UserDto.class))).thenReturn(userDto);
        ResponseEntity<UserDto> response = authController.registerAdmin(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService, times(1)).registerAdmin(userDto);
    }
}
