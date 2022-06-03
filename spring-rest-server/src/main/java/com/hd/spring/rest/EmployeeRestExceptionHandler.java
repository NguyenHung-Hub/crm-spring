package com.hd.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hd.spring.entity.ExceptionJSONInfo;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionJSONInfo> handlerException(EmployeeNotFoundException e) {
		ExceptionJSONInfo error = new ExceptionJSONInfo();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionJSONInfo>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
