package com.demo.poc.exception;

public class TransactionNotFoundException extends Exception{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public TransactionNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public TransactionNotFoundException() {
		super();
	}
	
	
	
}
