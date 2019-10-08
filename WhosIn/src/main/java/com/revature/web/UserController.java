package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.model.UserLoginRequestModel;
import com.revature.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="")
public class UserController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean verifyLogin(@RequestBody UserLoginRequestModel loginRequest) {
		User u = new User();
		u.setUsername(loginRequest.getUsername());
		u.setPassword(loginRequest.getPassword());
		u = userService.verifyLogin(u.getUsername(),u.getPassword());
		if(u == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
