package com.example.Bankmangement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bankmangement.payload.UserDto;
import com.example.bankmangement.service.UserService;
import com.example.bankmangement.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void testUpdateDetails() {
        long id = 1;
        UserDto userDto = new UserDto();
       

        when(userService.updateDetails(userDto, id)).thenReturn(userDto);

        UserDto result = userServiceImpl.updateDetails(userDto, id);

        assertEquals(userDto, result);
    }

    @Test
    public void testRegister() {
        UserDto userDto = new UserDto();
       

        when(userService.register(userDto)).thenReturn(userDto);

        UserDto result = userServiceImpl.register(userDto);

        assertEquals(userDto, result);
    }

    @Test
    public void testRegisterAdmin() {
        UserDto userDto = new UserDto();
        

        when(userService.registerAdmin(userDto)).thenReturn(userDto);

        UserDto result = userServiceImpl.registerAdmin(userDto);

        assertEquals(userDto, result);
    }
}

