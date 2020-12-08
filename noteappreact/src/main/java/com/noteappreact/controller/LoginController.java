package com.noteappreact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.noteappreact.model.Login;
import com.noteappreact.service.LoginService;



@RestController
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping("/noteapp/login")
    public String login(@RequestBody Login login) {
    
        boolean isValidated = loginService.loginValidation(login);
        if(isValidated) {
            
            return "Success";
        }
        else
            return "Not Success";
    }

 

}