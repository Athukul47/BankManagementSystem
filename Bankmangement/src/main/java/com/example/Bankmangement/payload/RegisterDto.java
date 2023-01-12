package com.example.Bankmangement.payload;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {	

	
	//@NotEmpty
	//@Size(max=50,message="name should be less than 50 ")
	
	private String name;
	
	private String username;

	private String password;
	
	private String address;
	
	private String state;
	
	private String country;
	
	private String email;
	
    private String pan;
	
	private long contactno;
	
	
	private Date dob;
	
	private String accountType;

}
