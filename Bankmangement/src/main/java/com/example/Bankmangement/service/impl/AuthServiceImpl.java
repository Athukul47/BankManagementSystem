package com.example.Bankmangement.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Bankmangement.entity.Role;
import com.example.Bankmangement.entity.User;
import com.example.Bankmangement.payload.LoginDto;
import com.example.Bankmangement.payload.RegisterDto;
import com.example.Bankmangement.repository.RoleRepository;
import com.example.Bankmangement.repository.UserRepository;
import com.example.Bankmangement.security.JwtTokenProvider;
import com.example.Bankmangement.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager ,UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider		) {
		this.authenticationManager = authenticationManager;
		this.userRepository=userRepository;
		this.roleRepository=roleRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtTokenProvider= jwtTokenProvider;
	}

	@Override
	public String login(LoginDto loginDto) {
	

	Authentication authentication=	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);	
	
	String token = jwtTokenProvider.generateToken(authentication);

  return token ;
	}

	@Override
    public String register(RegisterDto registerDto) {


       
        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setAddress(registerDto.getAddress());
        user.setState(registerDto.getState());
        user.setCountry(registerDto.getCountry());
        user.setEmail(registerDto.getEmail());
        user.setPan(registerDto.getPan());
        user.setContactno(registerDto.getContactno());
        user.setDob(registerDto.getDob());
        user.setAccountType(registerDto.getAccountType());

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName("Role_User").get();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        //TODO Validate the user before saving
        //Create the response class and add the saved data also http error/response codes
        

      return "user registered successfully";
    }
	@Override
    public RegisterDto updateDetails(RegisterDto registerDto,long id) {
        User user=userRepository.findById(id);

        user.setName(registerDto.getName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setAddress(registerDto.getAddress());
        user.setState(registerDto.getState());
        user.setCountry(registerDto.getCountry());
        user.setEmail(registerDto.getEmail());
        user.setPan(registerDto.getPan());
        user.setContactno(registerDto.getContactno());
        user.setDob(registerDto.getDob());
        user.setAccountType(registerDto.getAccountType());

        User updatedUser=userRepository.save(user);

        return mapToDto(updatedUser);
    }

    private RegisterDto mapToDto(User user){

        RegisterDto registerDto=new RegisterDto();
        registerDto.setName(user.getName());
        registerDto.setUsername(user.getUsername());
        registerDto.setPassword(passwordEncoder.encode(user.getPassword()));
        registerDto.setAddress(user.getAddress());
        registerDto.setState(user.getState());
        registerDto.setCountry(user.getCountry());
        registerDto.setEmail(user.getEmail());
        registerDto.setPan(user.getPan());
        registerDto.setContactno(user.getContactno());
        registerDto.setDob(user.getDob());
        registerDto.setAccountType(user.getAccountType());
        return registerDto;


    }
    
    @Override
    public String registerAdmin(RegisterDto registerDto) {


       
        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setAddress(registerDto.getAddress());
        user.setState(registerDto.getState());
        user.setCountry(registerDto.getCountry());
        user.setEmail(registerDto.getEmail());
        user.setPan(registerDto.getPan());
        user.setContactno(registerDto.getContactno());
        user.setDob(registerDto.getDob());
        user.setAccountType(registerDto.getAccountType());

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName("Role_Admin").get();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        //TODO Validate the user before saving
        //Create the response class and add the saved data also http error/response codes
        

      return "admin registered successfully";
    }
	}


