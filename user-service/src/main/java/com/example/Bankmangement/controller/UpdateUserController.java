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

import com.example.Bankmangement.payload.UserDto;
import com.example.Bankmangement.service.UserService;

@Controller
@RequestMapping("/authorize")
public class UpdateUserController {
	@Autowired
private UserService userService;

@PutMapping("/update/{id}")
 public ResponseEntity<UserDto> updateUser(@Valid @RequestBody   UserDto  userDto ,@PathVariable(name="id") long id)
{
UserDto updateResponse = userService.updateDetails(userDto, id);
return new ResponseEntity<>(updateResponse,HttpStatus.OK);




}

}

