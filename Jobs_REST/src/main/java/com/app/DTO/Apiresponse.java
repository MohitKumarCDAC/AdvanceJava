package com.app.DTO;

import java.time.LocalDate;

public class Apiresponse {
	
	private String message;
	private LocalDate date;
	
	
	public Apiresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apiresponse(String message) {
		super();
		this.message = message;
		this.date=LocalDate.now();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
