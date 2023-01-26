package com.example.Bankmangement.service;

import java.util.List;

import com.example.bankmangement.payload.LoanDto;

public interface LoanService {

 LoanDto applyLoan(long userId, LoanDto loanDto);

 LoanDto approveLoan(long id,LoanDto loanDto);
 LoanDto rejectLoan(long id,LoanDto loanDto);
 
 
 List<LoanDto> getAllLoan();
}

