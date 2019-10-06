package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findAll();
	public User findById(int id);
	public User findByUsername(String username);
	public <S extends User> S save(User u);
}
