package com.example.Bankmangement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.bankmangement.entity.Loan;
import com.example.bankmangement.entity.User;
import com.example.bankmangement.payload.LoanDto;
import com.example.bankmangement.repository.LoanRepository;
import com.example.bankmangement.repository.UserRepository;
import com.example.bankmangement.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private JavaMailSender mailSender;
	private LoanRepository loanRepository;
	private UserRepository userRepository;

	public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository) {
		this.loanRepository = loanRepository;
		this.userRepository = userRepository;
	}

	// apply Loan
	@Override
	public LoanDto applyLoan(long userId, LoanDto loanDto) {
		// dto to entity
		Loan loan = maptoEntity(loanDto);
		loan.setMessage("Pending");
		loan.setStatus("Pending");
		User user = userRepository.findById(userId);
		// set user to loan entity
		loan.setUser(user);
		Loan newloan = loanRepository.save(loan);
		// entity to dto
		return mapToDto(newloan);
	}

	public LoanDto approveLoan(long id, LoanDto loa) {
		Loan loanentity = new Loan();
		loanentity = loanRepository.findById(id).get();
		loanentity.setMessage(loa.getMessage());
		loanentity.setStatus("Approved");
		Loan updatedloan = loanRepository.save(loanentity);
		String email = loanRepository.getEmail(id);
		String subject = "Loan  Related information  ";
		String body = "Hi   greeting from xyz bank  .Your loan tracking id is   " + loanentity.getLoanType()
				+ "  is accepted  successfully . Thank you for choosing our bank . " + loanentity.getMessage();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("atharvakulkarni624@gmail.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		LoanDto loanresponse = new LoanDto();
		loanresponse = mapToDto(updatedloan);

		return loanresponse;

	}

	public LoanDto rejectLoan(long id, LoanDto loa) {
		Loan loanentity = new Loan();
		loanentity = loanRepository.findById(id).get();

		loanentity.setMessage(loa.getMessage());
		loanentity.setStatus("Rejected");
		Loan updatedloan = loanRepository.save(loanentity);

		String email = loanRepository.getEmail(id);
		String subject = "Loan  Related information  ";

		String body = "Hi   greeting from xyz bank  .Your loan tracking id is   " + loanentity.getLoanType()
				+ "  is rejected. You didnt match the eligibility level. " + loanentity.getMessage();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("atharvakulkarni624@gmail.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		LoanDto loanresponse = new LoanDto();
		loanresponse = mapToDto(updatedloan);

		return loanresponse;

	}

	@Override
	public List<LoanDto> getAllLoan(){
		List<Loan> loans = loanRepository.findAll();
		return loans.stream().map(loan ->mapToDto(loan)).collect(Collectors.toList());
		
	}

	private LoanDto mapToDto(Loan loan) {
		LoanDto loanDto = new LoanDto();
		loanDto.setId(loan.getId());
		loanDto.setLoanType(loan.getLoanType());
		loanDto.setLoanAmount(loan.getLoanAmount());
		loanDto.setDate(loan.getDate());
		loanDto.setRoi(loan.getRoi());
		loanDto.setStatus(loan.getStatus());
		loanDto.setMessage(loan.getMessage());
		loanDto.setLoanDuration(loan.getLoanDuration());
		return loanDto;
	}

	private Loan maptoEntity(LoanDto loanDto) {
		Loan loan = new Loan();
		loan.setId(loanDto.getId());
		loan.setLoanType(loanDto.getLoanType());
		loan.setLoanAmount(loanDto.getLoanAmount());
		loan.setDate(loanDto.getDate());
		loan.setRoi(loanDto.getRoi());
		loan.setLoanDuration(loanDto.getLoanDuration());
		return loan;
	}

}
