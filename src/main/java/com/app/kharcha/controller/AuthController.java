package com.app.kharcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;
import com.app.kharcha.services.UserService;

import jakarta.validation.Valid;

@Configuration
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/enter")
	public ResponseEntity<String> login()
	{
		return new ResponseEntity<String>("User logged in..",HttpStatus.OK);
	}

	@PostMapping("/newUser")
	public ResponseEntity<User> createNewUser(@Valid @RequestBody UserModel user)
	{
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	
	
}
