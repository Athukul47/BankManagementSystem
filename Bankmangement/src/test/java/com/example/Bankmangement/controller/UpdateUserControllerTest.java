package com.example.Bankmangement.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Bankmangement.payload.RegisterDto;
import com.example.Bankmangement.service.AuthService;

@ExtendWith(MockitoExtension.class)
public class UpdateUserControllerTest {

    @InjectMocks
    private UpdateUserController updateUserController;
    @Mock
    private AuthService authService;

    @Test
    public void testUpdateUser() {
        long id = 1;
        RegisterDto registerDto = new RegisterDto();
        when(authService.updateDetails(registerDto, id)).thenReturn(registerDto);
        ResponseEntity<RegisterDto> response = updateUserController.updateUser(registerDto, id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(registerDto, response.getBody());
    }
}