package com.example.Bankmangement.service;

import org.springframework.stereotype.Service;

import com.example.Bankmangement.payload.LoanDto;

public interface LoanService {

 LoanDto applyLoan(long userId, LoanDto loanDto);

 String approveLoan(long id,LoanDto loanDto);
 String rejectLoan(long id,LoanDto loanDto);
}

