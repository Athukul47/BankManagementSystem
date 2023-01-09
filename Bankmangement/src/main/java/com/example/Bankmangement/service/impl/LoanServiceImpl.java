package com.example.Bankmangement.service.impl;

import org.springframework.stereotype.Service;

import com.example.Bankmangement.entity.Loan;
import com.example.Bankmangement.entity.User;
import com.example.Bankmangement.payload.LoanDto;
import com.example.Bankmangement.repository.LoanRepository;
import com.example.Bankmangement.repository.UserRepository;
import com.example.Bankmangement.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	
	private LoanRepository loanRepository;
	private UserRepository userRepository;
	
	public LoanServiceImpl(LoanRepository loanRepository , UserRepository userRepository) {
		this.loanRepository = loanRepository;
		this.userRepository=userRepository;
	}
   //apply Loan 
	@Override
	public LoanDto applyLoan(long userId, LoanDto loanDto) {
		//dto to entity
		Loan loan=maptoEntity(loanDto);
		User user=userRepository.findById(userId);
		//set user to loan entity
		loan.setUser(user);
		Loan newloan=loanRepository.save(loan);
		//entity to dto
		return mapToDto(newloan);
	}

private LoanDto mapToDto(Loan loan)
	{
		LoanDto loanDto=new LoanDto();
		loanDto.setId(loan.getId());
		loanDto.setLoanType(loan.getLoanType());
		loanDto.setLoanAmount(loan.getLoanAmount());
		loanDto.setDate(loan.getDate());
		loanDto.setRoi(loan.getRoi());
		loanDto.setLoanDuration(loan.getLoanDuration());
		return loanDto;
	}
	
	private Loan maptoEntity(LoanDto loanDto)
	{
		Loan loan =new Loan();
		loan.setId(loanDto.getId());
		loan.setLoanType(loanDto.getLoanType());
		loan.setLoanAmount(loanDto.getLoanAmount());
		loan.setDate(loanDto.getDate());
		loan.setRoi(loanDto.getRoi());
		loan.setLoanDuration(loanDto.getLoanDuration());
		return loan;
	}

	

}
