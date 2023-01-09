package com.example.Bankmangement.payload;

import java.util.Date;

import lombok.Data;

@Data
public class LoanDto {
	private long id;
	
	private String loanType;
	
	private long loanAmount;
	private Date date;
	private long roi;
	private int loanDuration;
	}

