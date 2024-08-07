package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CustomerDetailsDto;
import com.app.DTO.SellingDetailsDto;
import com.app.Services.CustomerDetailsImpl;
import com.app.exception.AadharNumberNotFound;

@RestController
@RequestMapping("/api/customer")
public class CustomerDetailsController {

	@Autowired
	private CustomerDetailsImpl custdetailsServices;
	
	@PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDetailsDto customerDto) {
        CustomerDetailsDto customer = custdetailsServices.addCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
	
	 @PostMapping("/add-purchase")
	    public ResponseEntity<?> addSellingDetails(@RequestBody SellingDetailsDto sellingDetailDto) {
	        try {
	            SellingDetailsDto savesell = custdetailsServices.addSellingData(sellingDetailDto);
	            return ResponseEntity.status(HttpStatus.CREATED).body(savesell);
	        } catch (AadharNumberNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	 @GetMapping("/sells/aadhar/{aadharNumber}")
	    public ResponseEntity<?> getSellsByAadharNumber(@PathVariable String aadharNumber) {
	        try {
	            List<SellingDetailsDto> sells = custdetailsServices.getSellingDetailByAadharNumber(aadharNumber);
	            return ResponseEntity.ok(sells);
	        } catch (AadharNumberNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	 @GetMapping("/sells/date/{date}")
	    public ResponseEntity<?> getSellsDetailsByDate(@PathVariable String date) {
	        try {
	            LocalDate sellDate = LocalDate.parse(date);
	            List<SellingDetailsDto>sells = custdetailsServices.getSellingDetailsByDate(sellDate);
	            return ResponseEntity.ok(sells);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
	
}
