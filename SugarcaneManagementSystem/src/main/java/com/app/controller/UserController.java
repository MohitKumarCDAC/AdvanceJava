package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.UserRegistrationDto;
import com.app.Services.UserRegistrationServices;
import com.app.entity.Role;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserRegistrationServices userRegistration;
    
    @PostMapping
    @Operation(description = "Add User")
    public ResponseEntity<?> addUser(@RequestBody UserRegistrationDto userRegis) {
        return ResponseEntity.status(HttpStatus.OK).body(userRegistration.registerUser(userRegis));
    }
    
    @GetMapping("/customers")
    @Operation(description = "Get All Customers")
    public ResponseEntity<List<UserRegistrationDto>> getAllCustomers() {
        List<UserRegistrationDto> customers = userRegistration.getUsersByRole(Role.CUSTOMER);
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/farmers")
    @Operation(description = "Get All Farmers")
    public ResponseEntity<List<UserRegistrationDto>> getAllFarmers() {
        List<UserRegistrationDto> farmers = userRegistration.getUsersByRole(Role.FARMER);
        return ResponseEntity.status(HttpStatus.OK).body(farmers);
    }

    @GetMapping("/employees")
    @Operation(description = "Get All Employees")
    public ResponseEntity<List<UserRegistrationDto>> getAllEmployees() {
        List<UserRegistrationDto> employees = userRegistration.getUsersByRole(Role.EMPLOYEE);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/accountants")
    @Operation(description = "Get All Accountants")
    public ResponseEntity<List<UserRegistrationDto>> getAllAccountants() {
        List<UserRegistrationDto> accountants = userRegistration.getUsersByRole(Role.ACCOUNTANT);
        return ResponseEntity.status(HttpStatus.OK).body(accountants);
    }
}