package com.app.kharcha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;
import com.app.kharcha.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PostMapping("/newUser")
//	public User createNewUser(@Valid @RequestBody UserModel user)
//	{
//		return userService.createUser(user);
//	}
	
	@GetMapping("/profile")
	public User getUserById()
	{
		return userService.readUser();
	}
	
	@GetMapping("/getUsers")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	
	@PutMapping("/profile")
	public User updateUser(@Valid @RequestBody UserModel user)
	{
		return userService.updateUser(user);
	}
}
