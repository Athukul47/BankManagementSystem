package com.example.Bankmangement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bankmangement.payload.LoanDto;
import com.example.bankmangement.repository.LoanRepository;
import com.example.bankmangement.service.LoanService;
import com.example.bankmangement.service.impl.LoanServiceImpl;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanService loanService;
    @Mock
    LoanRepository loanrepository;

    @InjectMocks
    private LoanServiceImpl loanServiceImpl;

    @Test
    public void testApplyLoan() {
        long userId = 1;
        LoanDto loanDto = new LoanDto();
        loanDto.setId(1);
        loanDto.setStatus("APPLIED");

        when(loanService.applyLoan(userId, loanDto)).thenReturn(loanDto);

        LoanDto result = loanServiceImpl.applyLoan(userId, loanDto);

        assertEquals(loanDto, result);
    }

    @Test
    void testApproveLoan() {
        long id = 1;
        LoanDto loanDto = new LoanDto();
        loanDto.setId(1);
        loanDto.setStatus("APPROVED");

        when(loanService.approveLoan(id, loanDto)).thenReturn(loanDto);

        LoanDto result = loanServiceImpl.approveLoan(id, loanDto);

        assertEquals(loanDto, result);
    }

    @Test
    void testRejectLoan() {
        long id = 1;
        LoanDto loanDto = new LoanDto();
        loanDto.setId(1);
        loanDto.setStatus("REJECTED");

        when(loanService.rejectLoan(id, loanDto)).thenReturn(loanDto);

        LoanDto result = loanServiceImpl.rejectLoan(id, loanDto);

        assertEquals(loanDto, result);
    }

    @Test
    void testGetAllLoan() {
        LoanDto loan1 = new LoanDto();
        loan1.setId(1);
        
        loan1.setStatus("APPROVED");

        LoanDto loan2 = new LoanDto();
        loan2.setId(2);
        
        loan2.setStatus("APPLIED");

        List<LoanDto> expectedLoanList = Arrays.asList(loan1, loan2);

        when(loanService.getAllLoan()).thenReturn(expectedLoanList);
        List<LoanDto> result = loanServiceImpl.getAllLoan();

        assertEquals(expectedLoanList, result);
    }
}

