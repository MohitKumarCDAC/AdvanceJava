package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.UserRegistrationDto;
import com.app.Services.UserRegistrationServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/registration")
public class UserController {

	    @Autowired
	    private UserRegistrationServices userRegistration;
	    
	    @PostMapping
	    @Operation(description = "Add User")
	    public ResponseEntity<?> addUser(@RequestBody UserRegistrationDto userRegis)
	    {
	    	return ResponseEntity.status(HttpStatus.OK).body(userRegistration.registerUser(userRegis));
	    }
	    
}
