package com.app.ExceptionHandler;

public class JobNotFoundException extends RuntimeException{
   public JobNotFoundException(String msg)
   {
	   super(msg);
   }
}
