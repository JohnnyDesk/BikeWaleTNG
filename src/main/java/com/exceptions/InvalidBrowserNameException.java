package com.exceptions;

public class InvalidBrowserNameException extends RuntimeException{
	
	private String browser = null;
	
	public InvalidBrowserNameException(String browserName) {
		browser = browserName;
	}
	
	@Override
	public String getMessage() {
		return "Invalid Browser Name Entered: " + "\"" + browser + "\"";
	}

}
