package com.demo.poc.config;

public class DataNotFoundException extends Exception {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String errorMessage;
	private String errorCode;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public DataNotFoundException(String id, String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getId() {
		return errorCode;
	}

	public void setId(String id) {
		this.errorCode = id;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}