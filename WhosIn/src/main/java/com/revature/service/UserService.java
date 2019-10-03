package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service(value="userService")
public class UserService {
	private UserRepository userRepository;
	
	public UserService() {
		super();
	}
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public void save(User u) {
		userRepository.save(u);
	}
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	public User findByUseremail(String useremail) {
		return userRepository.findByUseremail(useremail);
	}
	
	@Autowired
	public void setMovieRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}