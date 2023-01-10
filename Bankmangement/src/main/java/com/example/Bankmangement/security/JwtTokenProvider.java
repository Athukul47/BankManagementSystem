package com.example.Bankmangement.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.CodecException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app-jwt-expiration-milliseconds}")
	private long jwtExpirationDate;
	
	//generate JWT Token
	public String generateToken(Authentication authentication) {
		
		String username = authentication.getName();
		
		
		
		Date currentDate = new Date();
		
		Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
		
		String token = Jwts.builder()
			.setSubject(username)
			.setIssuedAt(new Date())
			.setExpiration(expireDate)
			.signWith(key())
			.compact();
		
		return token;
		
	}
	
	private Key key() {
		
		return Keys.hmacShaKeyFor(
				
				Decoders.BASE64.decode(jwtSecret)
				
				);
		
		}
	// get username from Jwt token
	public String getUsername(String token) {
		Claims claims =Jwts.parserBuilder()
		.setSigningKey(key())
		.build()
		.parseClaimsJws(token)
		.getBody();
		
		String username = claims.getSubject();
		return username;
		
	}
	
	// validate jwt token
	public boolean ValidateToken(String token) {
		
	
		Jwts.parserBuilder()
		.setSigningKey(key())
		.build()
		.parse(token);
		return true;
		
		
		} 	
			
		}
		
	
	


