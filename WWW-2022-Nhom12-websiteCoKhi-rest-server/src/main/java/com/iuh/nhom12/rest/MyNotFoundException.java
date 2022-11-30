package com.iuh.nhom12.rest;

public class MyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MyNotFoundException(String message) {
		super(message);
	}
	
	public MyNotFoundException(Throwable cause) {
		super(cause);
	}
}
