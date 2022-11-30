package com.iuh.nhom12.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<MyErrorResponse> handException(Exception ex) {
		MyErrorResponse errorResponse = new MyErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
