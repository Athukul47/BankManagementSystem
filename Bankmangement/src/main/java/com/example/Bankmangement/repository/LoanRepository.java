package com.example.Bankmangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bankmangement.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long>{

}
