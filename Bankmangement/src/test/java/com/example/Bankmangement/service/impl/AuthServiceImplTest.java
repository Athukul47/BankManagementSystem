package com.example.Bankmangement.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bankmangement.payload.CredentialDto;
import com.example.bankmangement.security.JwtTokenProvider;
import com.example.bankmangement.service.impl.AuthServiceImpl;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {
    
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtTokenProvider jwtTokenProvider;
    @InjectMocks
    private AuthServiceImpl authService;
    
    private CredentialDto credentialDto;
    private Authentication authentication;
    private String expectedToken = "test-token";
    
    @BeforeEach
    public void setUp() {
        credentialDto = new CredentialDto("test-username", "test-password");
        authentication = new UsernamePasswordAuthenticationToken("test-username", "test-password",
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(jwtTokenProvider.generateToken(authentication)).thenReturn(expectedToken);
       
    }
    
    @Test
    void testLogin() {
        String token = authService.login(credentialDto);
        assertEquals(expectedToken, token);
        assertEquals(authentication, SecurityContextHolder.getContext().getAuthentication());
        verify(authenticationManager,times(1)).authenticate(any());
    }
}
