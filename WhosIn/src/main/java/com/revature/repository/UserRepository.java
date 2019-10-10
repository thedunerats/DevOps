package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findById(int id);
	public User findByUsernameAndPassword(String username, String password);
}
