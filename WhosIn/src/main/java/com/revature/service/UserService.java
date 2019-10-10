package com.revature.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service(value="userService")
public class UserService {
	private UserRepository userRepository;
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	public User verifyLogin(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}