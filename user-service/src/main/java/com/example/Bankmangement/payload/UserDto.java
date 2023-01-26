package com.example.Bankmangement.payload;

import java.util.Date;

import javax.validation.constraints.Email;
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
public class UserDto {	

	
	//@NotEmpty
	//@Size(max=50,message="name should be less than 50 ")
	
	@NotEmpty
    @Size(max=50,message="name should be less than 50 characters ")
    private String name;
    @Size(min=8,max=20,message="username should be of 8 to 20 character")
 
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message="enter valid password consisting of Capital letter,smallletter numbers and special character")
    private String password;
    @Size(max=200,message="address can't be more than 200 character")
    private String address;
    @Size(max=50,message="state name can't be more than 50 character")
    private String state;
    @Size(max=100,message="country name can't be more than 100 character")
    private String country;
    @Email(message="format should be valid")
    private String email;
    @Size(min=10,max=10,message="Enter valid pan number")
    private String pan;
    private long contactno;
    private Date dob;
    @Size(max=50,message="size of account type can't be more than 50")
    private String accountType;
}
