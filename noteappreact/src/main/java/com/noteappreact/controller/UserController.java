package com.noteappreact.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.noteappreact.model.Login;
import com.noteappreact.model.User;
import com.noteappreact.service.LoginService;
import com.noteappreact.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	 @PostMapping("/noteapp/register")
	    public String registration(@RequestBody User user) {
	        
	        String registrationResponse = userService.registation(user);
	        if(registrationResponse.equals("Success")) {
	            Login login = new Login();
	            login.setUserName(user.getUserName());
	            login.setPassword(user.getPassword());
	            loginService.addLoginDetails(login);
	            return registrationResponse;
	        }
	        
	        return registrationResponse;
	    }

	 

	}

