package com.example.Bankmangement.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bankmangement.entity.Role;
import com.example.bankmangement.entity.User;
import com.example.bankmangement.exception.LoanApiException;
import com.example.bankmangement.payload.UserDto;
import com.example.bankmangement.repository.RoleRepository;
import com.example.bankmangement.repository.UserRepository;
import com.example.bankmangement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
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
	
	
	@Override
    public UserDto register(UserDto userDto) {

		if(userRepository.existsByUsername(userDto.getUsername())){
            throw new LoanApiException(HttpStatus.BAD_REQUEST,"Username Already Exist");
        }
       
        User user=new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(userDto.getAddress());
        user.setState(userDto.getState());
        user.setCountry(userDto.getCountry());
        user.setEmail(userDto.getEmail());
        user.setPan(userDto.getPan());
        user.setContactno(userDto.getContactno());
        user.setDob(userDto.getDob());
        user.setAccountType(userDto.getAccountType());

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName("Role_User").get();
        roles.add(userRole);
        user.setRoles(roles);
    User registerUser =     userRepository.save(user);
        
        

      return mapToDto(registerUser);
    }
	

    
    
    @Override
    public UserDto registerAdmin(UserDto userDto) {


       
        User user=new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(userDto.getAddress());
        user.setState(userDto.getState());
        user.setCountry(userDto.getCountry());
        user.setEmail(userDto.getEmail());
        user.setPan(userDto.getPan());
        user.setContactno(userDto.getContactno());
        user.setDob(userDto.getDob());
        user.setAccountType(userDto.getAccountType());

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName("Role_Admin").get();
        roles.add(userRole);
        user.setRoles(roles);
        User registerAdmin =     userRepository.save(user);
        
        

        return mapToDto(registerAdmin);
        
        

      
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
