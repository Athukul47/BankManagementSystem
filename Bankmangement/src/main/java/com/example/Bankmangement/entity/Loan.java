package com.example.Bankmangement.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//loan entity

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Entity
	@Table (name="Loan")
	public class Loan {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private String loanType;
		private long loanAmount;
		private Date date;
		private long roi;
		private int loanDuration;
		private String status;
		private String message;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id",nullable=false)
		private User user;
		

	}
	 



