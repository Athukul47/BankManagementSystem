package com.example.Bankmangement.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.Bankmangement.payload.LoanDto;
import com.example.Bankmangement.service.LoanService;

@ExtendWith(MockitoExtension.class)
 class LoanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    @Test
     void approveLoan_ShouldReturnAccepted() throws Exception {
        when(loanService.approveLoan(anyLong(), any(LoanDto.class))).thenReturn(new LoanDto());

        mockMvc.perform(put("/authorize/approve/{id}", 1L)
                .with(user("admin").roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isAccepted());
       
        
    }

    @Test
     void rejectLoan_ShouldReturnAccepted() throws Exception {
        when(loanService.rejectLoan(anyLong(), any(LoanDto.class))).thenReturn(new LoanDto());

        mockMvc.perform(put("/authorize/reject/{id}", 1L)
                .with(user("admin").roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isAccepted());
        
    }

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();
    }
}
