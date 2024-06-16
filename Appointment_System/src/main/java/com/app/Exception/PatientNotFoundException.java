package com.app.Exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String msg) {
    	super(msg);
    }
}
