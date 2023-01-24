package com.example.Bankmangement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Bankmangement.entity.User;
import com.example.Bankmangement.payload.UserDto;
import com.example.Bankmangement.repository.UserRepository;
import com.example.Bankmangement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
    public UserDto updateDetails(UserDto userDto,long id) {
        User user=userRepository.findById(id);

        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(userDto.getAddress());
        user.setState(userDto.getState());
        user.setCountry(userDto.getCountry());
        user.setEmail(userDto.getEmail());
        user.setPan(userDto.getPan());
        user.setContactno(userDto.getContactno());
        user.setDob(userDto.getDob());
        user.setAccountType(userDto.getAccountType());

        User updatedUser=userRepository.save(user);

        return mapToDto(updatedUser);
    }
	
	private UserDto mapToDto(User user){

        UserDto userDto=new UserDto();
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(passwordEncoder.encode(user.getPassword()));
        userDto.setAddress(user.getAddress());
        userDto.setState(user.getState());
        userDto.setCountry(user.getCountry());
        userDto.setEmail(user.getEmail());
        userDto.setPan(user.getPan());
        userDto.setContactno(user.getContactno());
        userDto.setDob(user.getDob());
        userDto.setAccountType(user.getAccountType());
        return userDto;


    }

}
