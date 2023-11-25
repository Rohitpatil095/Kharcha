package com.app.kharcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.kharcha.entity.LoginModel;
import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;
import com.app.kharcha.services.UserService;

import jakarta.validation.Valid;

@Configuration
@RestController
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	AuthenticationManager authManager;
	
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

//	@PostMapping("/login")
//	public ResponseEntity<HttpStatus> userLogin(@RequestBody LoginModel lModel)
//	{
//		Authentication auth= authManager.authenticate(new UsernamePasswordAuthenticationToken(lModel.getEmail(),lModel.getPass()));
//		SecurityContextHolder.getContext().setAuthentication(auth);
//		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//	}

	@Bean
	public BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception
//	{
//		return super.authenticationManagerBean();
//	}
}
