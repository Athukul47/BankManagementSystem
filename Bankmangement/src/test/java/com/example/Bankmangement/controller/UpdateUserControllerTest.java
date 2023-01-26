package com.example.Bankmangement.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.bankmangement.controller.UpdateUserController;
import com.example.bankmangement.payload.UserDto;
import com.example.bankmangement.service.AuthService;
import com.example.bankmangement.service.UserService;

@ExtendWith(MockitoExtension.class)
 class UpdateUserControllerTest {

    @InjectMocks
    private UpdateUserController updateUserController;
    @Mock
    private UserService userService;

    @Test
     void testUpdateUser() {
        long id = 1;
        UserDto userDto = new UserDto();
        when(userService.updateDetails(userDto, id)).thenReturn(userDto);
        ResponseEntity<UserDto> response = updateUserController.updateUser(userDto, id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService,times(1)).updateDetails(userDto, id);
    }
}