package com.app.Exception;

public class AuthorNotFoundException extends RuntimeException {
  public AuthorNotFoundException(String msg)
  {
	  super(msg);
  }
}
