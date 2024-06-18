package com.app.Exception;

public class RecipeNotFoundException extends RuntimeException{

	public RecipeNotFoundException(String msg)
	{
		super(msg);
	}
}
