package com.demo.poc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CustomerDetails implements Serializable{
	private static final long serialVersionUID = -9200457912598641255L;
	
	@ApiModelProperty(notes = "The database generated customer ID")
	private Long customerId;
	
	@ApiModelProperty(notes = "Customer first name")
	private String firstName;
	
	@ApiModelProperty(notes = "Customer last name")
	private String lastName;
	
	@ApiModelProperty(notes = "Customer date of birth")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dob;
	
	@ApiModelProperty(notes = "device number (card number) ")
	private List<DeviceDetails> deviceDetails ;
	
	public CustomerDetails() {
		super();
	}
	
	public CustomerDetails(Long customerId, String firstName, String lastName, Date dob, List<DeviceDetails> deviceDetails) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.deviceDetails = deviceDetails;
	}
	
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<DeviceDetails> getDeviceDetails() {
		return deviceDetails;
	}
	public void setDeviceDetails(List<DeviceDetails> deviceDetails) {
		this.deviceDetails = deviceDetails;
	}
	
}
