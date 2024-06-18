package com.app.ExceptionHandler;

public class RoomNotAvailableException extends RuntimeException{
       public RoomNotAvailableException(String msg)
       {
    	   super(msg);
       }
}
