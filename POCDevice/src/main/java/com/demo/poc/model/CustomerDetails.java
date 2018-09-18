package com.mc.techm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="customer_details")
public class CustomerDetails implements Serializable{
	private static final long serialVersionUID = -9200457912598641255L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated customer ID")
	@Column(name="customer_id")
	private Long customerId;
	
	@ApiModelProperty(notes = "Customer first name")
	@Column(name="first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "Customer last name")
	@Column(name="last_name")
	private String lastName;
	
	@ApiModelProperty(notes = "Customer date of birth")
	@Column(name="dob")
	private Date dob;
	
	@ApiModelProperty(notes = "device number (card number) ")
//	@Column(name="device_number")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customerDetails")
	private Set<DeviceDetails> deviceDetails = new HashSet<>();
	
	public CustomerDetails() {
		super();
	}
	
	public CustomerDetails(Long customerId, String firstName, String lastName, Date dob, Set<DeviceDetails> deviceDetails) {
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
	public Set<DeviceDetails> getDeviceDetails() {
		return deviceDetails;
	}
	public void setDeviceDetails(Set<DeviceDetails> deviceDetails) {
		this.deviceDetails = deviceDetails;
	}
	
} 