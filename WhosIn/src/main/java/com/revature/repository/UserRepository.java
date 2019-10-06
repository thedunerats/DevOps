package com.revature.repository;

import java.util.List;

import com.revature.model.User;

public interface UserRepository {
	List<User> getAllUsers();
	User getUserById(int id);
	void insertUser(User u);
	int verifyLogin(String eMail, String pass);
}
