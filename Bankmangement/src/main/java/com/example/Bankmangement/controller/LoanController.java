package com.example.Bankmangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bankmangement.payload.LoanDto;
import com.example.Bankmangement.service.LoanService;

@RestController
@RequestMapping("/authorize")
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

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/approve/{id}")
	public ResponseEntity<LoanDto> approveLoan(@PathVariable(value="id")  long id ,@RequestBody LoanDto loanDto){
		
		
		return new ResponseEntity<>(loanService.approveLoan(id,loanDto),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/reject/{id}")
	public ResponseEntity<LoanDto>  rejectLoan(@PathVariable(value="id")  long id ,@RequestBody LoanDto loanDto){
		
		return new ResponseEntity<>(loanService.rejectLoan(id,loanDto),HttpStatus.ACCEPTED);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/getloans")
//	public List<LoanDto> allLoan(){
//		System.out.println("Inside get all loans");
//		return loanService.showAllLoan();
//	}
	@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/getloans")
public List<LoanDto> allLoan(){
	return loanService.showAllLoan();
}


}
