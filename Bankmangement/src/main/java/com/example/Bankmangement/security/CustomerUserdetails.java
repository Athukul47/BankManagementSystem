package com.example.Bankmangement.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bankmangement.entity.User;
import com.example.bankmangement.repository.UserRepository;

@Service
public class CustomerUserdetails implements UserDetailsService{

	
	private UserRepository userRepository;
	
	public CustomerUserdetails(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User user=	userRepository.findByUsername(username).orElseThrow(() -> 
		new UsernameNotFoundException("user not found "+username));
	
	Set<GrantedAuthority> authorities=user
			.getRoles().stream()
			.map((role) ->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
		
		
	}

}
