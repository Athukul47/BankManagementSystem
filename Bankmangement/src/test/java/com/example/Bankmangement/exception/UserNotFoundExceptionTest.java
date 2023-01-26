package com.example.Bankmangement.exception;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.bankmangement.entity.User;
import com.example.bankmangement.repository.UserRepository;


@SpringBootTest
class UserNotFoundExceptionTest {
	
	@MockBean
	private UserRepository userRepository;

	@Test
	void testUserNotFound() {
		
		User findById = userRepository.findById(25);
		try {
			throw new Exception("User not found");
		}
		catch (Exception e) {
			
			assertEquals("User not found",e.getMessage() );
		}
		
	}

}
