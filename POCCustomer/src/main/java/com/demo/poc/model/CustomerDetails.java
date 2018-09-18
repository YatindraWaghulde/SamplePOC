package com.demo.poc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dob;
	
	@ApiModelProperty(notes = "device number (card number) ")
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id",referencedColumnName="customer_id")
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
