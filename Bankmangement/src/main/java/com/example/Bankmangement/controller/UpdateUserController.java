package com.example.Bankmangement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bankmangement.payload.RegisterDto;
import com.example.Bankmangement.service.AuthService;

@Controller
@RequestMapping("/api")
public class UpdateUserController {
	@Autowired
private AuthService authService;

@PutMapping("/update/{id}")
 public ResponseEntity<RegisterDto> updateUser(@RequestBody   RegisterDto  registerDto ,@PathVariable(name="id") long id)
{
RegisterDto updateResponse= authService.updateDetails(registerDto, id);
return new ResponseEntity<>(updateResponse,HttpStatus.OK);




}

}

