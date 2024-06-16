package com.app.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Apiresponse {
	private String message;
	private LocalDateTime timeStamp;
	public Apiresponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
	@Override
	public String toString() {
		return "Apiresponse [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
}
