package com.example.Bankmangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bankmangement.payload.LoanDto;
import com.example.Bankmangement.service.LoanService;

@Controller
@RequestMapping("/api")
public class LoanController {
	
	@Autowired
	private LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}
	
	@PostMapping("/user/{userId}/loan")
	public ResponseEntity<LoanDto> applyLoan(@PathVariable(value="userId") long userId,@RequestBody LoanDto loanDto)
	{
		return new ResponseEntity<>(loanService.applyLoan(userId,loanDto),HttpStatus.CREATED);
	}

}
