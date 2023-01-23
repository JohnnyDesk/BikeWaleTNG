package com.exceptions;

public class InvalidKeyName extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "Invalid Key Name Provided";
	}
	

}
