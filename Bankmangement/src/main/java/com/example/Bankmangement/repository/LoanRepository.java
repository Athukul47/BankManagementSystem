package com.example.Bankmangement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Bankmangement.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long>{
	
	@Query(value="select users.email from users ,loan where  users.id=loan.user_id AND loan.id=? ",nativeQuery=true)
    public String getEmail(long id);

	@Query(value="select * from loan " ,nativeQuery=true)
	public List<Loan> getAllLoan();
	
}
