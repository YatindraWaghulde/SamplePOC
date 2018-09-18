package com.demo.poc.config;

public class DeviceNotFoundException extends Exception{
	
	/**
 * 
 */
private static final long serialVersionUID = 1L;

private String errorMessage;

public DeviceNotFoundException(String errorMessage) {
	super(errorMessage);
	this.errorMessage = errorMessage;
}

public String getErrorMessage() {
	return errorMessage;
}

public DeviceNotFoundException() {
	super();
}



}