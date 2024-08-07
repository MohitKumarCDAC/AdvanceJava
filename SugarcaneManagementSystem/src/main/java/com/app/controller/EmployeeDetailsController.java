package com.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.EmployeeDetailsDto;
import com.app.DTO.SalaryDetailsDto;
import com.app.Services.EmployeeDetailsServices;
import com.app.exception.AadharNumberNotFound;

@RestController
@RequestMapping("api/employeeDetails")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsServices service;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDetailsDto employeedto) {
        try {
            EmployeeDetailsDto savedEmployee = service.saveEmployeeDetails(employeedto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        } catch (AadharNumberNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/add-salary")
    public ResponseEntity<?> addAccountantSalary(@RequestBody SalaryDetailsDto salaryDto) {
        try {
            SalaryDetailsDto savedSalary = service.addEmployeeSalary(salaryDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSalary);
        } catch (AadharNumberNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/salaries/{aadharNumber}")
    public ResponseEntity<?> getAllSalaries(@PathVariable String aadharNumber) {
        try {
            List<SalaryDetailsDto> salaries = service.getAllSalariesByAadharNumber(aadharNumber);
            return ResponseEntity.ok(salaries);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/update/{aadharNumber}")
    public ResponseEntity<?> updateEmployeeDetails(@PathVariable String aadharNumber, @RequestBody EmployeeDetailsDto employeedto) {
        try {
            EmployeeDetailsDto updatedEmployee = service.updateEmployeeDetails(aadharNumber, employeedto);
            return ResponseEntity.ok(updatedEmployee);
        } catch (AadharNumberNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
