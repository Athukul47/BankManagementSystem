package com.example.Bankmangement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.bankmangement.payload.CredentialDto;
import com.example.bankmangement.security.JwtTokenProvider;
import com.example.bankmangement.service.impl.AuthServiceImpl;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @InjectMocks
    private AuthServiceImpl authService;
    

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtTokenProvider jwtTokenProvider;
    
    private Authentication authentication;

    private CredentialDto testCredentialDto = new CredentialDto("test", "test");
    private String testToken = "testToken";

    
    
    @BeforeEach
    public void setUp() {
       testCredentialDto = new CredentialDto("test-username", "test-password");
        authentication = new UsernamePasswordAuthenticationToken("test-username", "test-password",
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(jwtTokenProvider.generateToken(authentication)).thenReturn(testToken);
    }
    @Test
   
     void testLogin() {
        
        String token = authService.login(testCredentialDto);

        assertNotNull(token);
        assertEquals(testToken, token);
        verify(authenticationManager,times(1)).authenticate(any());
    }
}

