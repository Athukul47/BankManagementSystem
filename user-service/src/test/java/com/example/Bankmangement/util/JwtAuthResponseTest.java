package com.example.Bankmangement.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bankmangement.payload.JwtAuthResponse;


@SpringBootTest
class JwtAuthResponseTest {
	
	
	

	@Test
	void testGetterSetterToString() {
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse("e12dkfdfdfkd"," Bearer");
		assertEquals("e12dkfdfdfkd",jwtAuthResponse.getAccessToken());
		jwtAuthResponse.setAccessToken("eetdvgferef");
		assertEquals("eetdvgferef",jwtAuthResponse.getAccessToken());
		
		assertEquals(jwtAuthResponse.toString(),jwtAuthResponse.toString());
	
	}

}
