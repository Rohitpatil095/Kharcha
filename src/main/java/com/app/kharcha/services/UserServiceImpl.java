package com.app.kharcha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;
import com.app.kharcha.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createUser(UserModel user) {
		User newUser= new User();
		BeanUtils.copyProperties(user,newUser);
		return userRepo.save(newUser);
	}

	@Override
	public User readUser(int id) {
		Optional<User> currUser= userRepo.findById(id);
		
		if(currUser.isPresent())
		{
			return currUser.get();
		}
		return null;
	}

	@Override
	public User updateUser(int id, UserModel user) {
		User currUser= readUser(id);
		if(currUser==null)
		{
			return null;
		}
		currUser.setAge(user.getAge()!=0 ? user.getAge() : currUser.getAge());
		currUser.setEmail(user.getEmail() !=null ? user.getEmail() : currUser.getEmail());
		currUser.setName(user.getName() !=null ? user.getName() : currUser.getName());
		currUser.setPassword(user.getPassword()!=null ? user.getPassword() : currUser.getPassword());
		return userRepo.save(currUser);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

}
