package com.example.Bankmangement.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bankmangement.entity.Loan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    @Test
    public void testGetEmail() {
        String email = loanRepository.getEmail(1);
        assertEquals("sarthakgupta1351@gmail.com", email);
    }

    @Test
    public void testGetAllLoan() {
        List<Loan> loans = loanRepository.getAllLoan();
        assertEquals(3, loans.size());
    }
}

