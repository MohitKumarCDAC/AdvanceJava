package com.app.ExceptionHandler;

public class ReservationNotFoundException extends RuntimeException{

	public ReservationNotFoundException(String msg)
	{
		super(msg);
	}
}
