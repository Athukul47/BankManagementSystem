package com.example.Bankmangement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Bankmangement.payload.LoanDto;

public interface LoanService {

 LoanDto applyLoan(long userId, LoanDto loanDto);

 LoanDto approveLoan(long id,LoanDto loanDto);
 LoanDto rejectLoan(long id,LoanDto loanDto);
 
 //List<LoanDto> showAllLoan();
 List<LoanDto> showAllLoan();
}

