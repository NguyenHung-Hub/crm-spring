package com.hd.spring.rest;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
