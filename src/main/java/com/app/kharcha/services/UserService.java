package com.app.kharcha.services;

import java.util.List;

import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;

public interface UserService {
	
	public User createUser(UserModel user);
	public User readUser(int id);
	public List<User> getAllUser();
	public User updateUser(int id, UserModel user);
	public User getUserByEmail(String email);
}
