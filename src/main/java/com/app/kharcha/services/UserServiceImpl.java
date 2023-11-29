package com.app.kharcha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.kharcha.entity.User;
import com.app.kharcha.entity.UserModel;
import com.app.kharcha.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder;
	
	@Override
	public User createUser(UserModel user) {
		User newUser= new User();
		BeanUtils.copyProperties(user,newUser);
//		newUser.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(newUser);
	}

	@Override
	public User readUser() {
		int id= getLoggedInUser().getId();
		Optional<User> currUser= userRepo.findById(id);
		
		if(currUser.isPresent())
		{
			return currUser.get();
		}
		return null;
	}

	@Override
	public User updateUser(UserModel user) {
		User currUser= readUser();
		if(currUser==null)
		{
			return null;
		}
		currUser.setAge(user.getAge()!=0 ? user.getAge() : currUser.getAge());
		currUser.setEmail(user.getEmail() !=null ? user.getEmail() : currUser.getEmail());
		currUser.setName(user.getName() !=null ? user.getName() : currUser.getName());
		currUser.setPassword(user.getPassword()!=null ?  encoder.encode(user.getPassword()): currUser.getPassword());
// reverting encoding for testing
//		currUser.setPassword(user.getPassword()!=null ?  encoder.encode(user.getPassword()): currUser.getPassword());
		return userRepo.save(currUser);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		User existingUser= userRepo.findUserByEmail(email);
		if(existingUser!=null)
		{
			return existingUser;
		}
		return null;
	}

	@Override
	public User getLoggedInUser() {
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		User u=userRepo.findUserByEmail(email);
		if(u ==null)
		{
//			return new UsernameNotFoundException("user not present");
			return null;
		}
		return u;
	}

}
