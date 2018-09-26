package com.demo.poc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerDetailsVO implements Serializable{
	private static final long serialVersionUID = -9200457912598641255L;
	
	private Long customerId;
	
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private List<DeviceDetailsVO> deviceDetails ;
	
	public CustomerDetailsVO() {
		super();
	}
	
	public CustomerDetailsVO(Long customerId, String firstName, String lastName, Date dob, List<DeviceDetailsVO> deviceDetails) {
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
	public List<DeviceDetailsVO> getDeviceDetails() {
		return deviceDetails;
	}
	public void setDeviceDetails(List<DeviceDetailsVO> deviceDetails) {
		this.deviceDetails = deviceDetails;
	}
	
}
