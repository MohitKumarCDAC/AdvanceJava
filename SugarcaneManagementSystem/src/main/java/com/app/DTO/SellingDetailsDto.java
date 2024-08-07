package com.app.DTO;

import java.time.LocalDate;

import com.app.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellingDetailsDto {
	
	 private Product productName;
	 
	
	 private double productweight;
	 
	 
	 private double productrate;
	 
	
	 private double totalPrice;
	 
	 
	 private double paidBalance;
	 private double credit;
	 
	 
	 private LocalDate sellingDate;
	 
	 private String aadharNumber;


}
