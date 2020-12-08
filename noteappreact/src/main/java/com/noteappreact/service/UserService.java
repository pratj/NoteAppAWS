package com.noteappreact.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noteappreact.model.User;
import com.noteappreact.repository.UserRepository;





@Service
public class UserService {
   
    @Autowired
    private UserRepository userRepository;
   
    public String registation(User user) {
       
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        String errorMessage = "";
        for (ConstraintViolation<User> violation : violations) {
            errorMessage = violation.getMessage();
        }
       
        if(errorMessage.equals("")) {
            userRepository.save(user);
            return "Success";
        }
        else {
            return errorMessage;
        }
    }
}

