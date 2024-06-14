package com.app.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponses {
 private String message;
 private LocalDateTime time;
public ApiResponses(String message) {
	this.message = message;
	this.time=LocalDateTime.now();
}
 
 
}
