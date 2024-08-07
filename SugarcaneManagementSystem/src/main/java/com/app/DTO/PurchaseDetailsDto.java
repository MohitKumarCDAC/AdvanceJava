package com.app.DTO;

import java.time.LocalDate;

import com.app.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDetailsDto {
	
	 private Product productName;
	 
	 
	 private double productweight;
	 
	 
	 private double productrate;
	 
	 
	 private double totalPrice;
	 
	 
	 private double paidBalance;
	 
	 private double credit;
	 
	 
	 private LocalDate purchaseDate;
	 
	 private String aadharNumber;

}
