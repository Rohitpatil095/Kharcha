package com.app.kharcha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;
import com.app.kharcha.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/newUser")
	public User createNewUser(@Valid @RequestBody UserModel user)
	{
		return userService.createUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable int id)
	{
		return userService.readUser(id);
	}
	
	@GetMapping("/getUsers")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@Valid @RequestBody UserModel user, @PathVariable int id)
	{
		return userService.updateUser(id, user);
	}
}
