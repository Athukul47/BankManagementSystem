package com.example.Bankmangement.service;

import com.example.Bankmangement.payload.UserDto;

public interface UserService {
	
	UserDto updateDetails(UserDto userDto,long id);
	
		UserDto register(UserDto userDto);

	
	UserDto registerAdmin(UserDto userDto);


}
