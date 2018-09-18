package com.demo.poc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Entity
@Table(name="device_details")
public class DeviceDetails implements Serializable{

	private static final long serialVersionUID = -8658798312716361398L;
	public DeviceDetails() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deviceNumber;
	
	private String deviceType;
	private Date expDate;
	private Integer txnLimit;
	
	@JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinColumn(name = "customer_id")
	 private CustomerDetails customerDetails;
	

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	
	public DeviceDetails(Integer deviceNumber, String deviceType, Date expDate, Integer txnLimit,CustomerDetails customerDetails) {
		super();
		this.deviceNumber = deviceNumber;
		this.deviceType = deviceType;
		this.expDate = expDate;
		this.txnLimit = txnLimit;
		this.customerDetails = customerDetails;
	}
	public void setDeviceNumber(Integer deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public void setTxnLimit(Integer txnLimit) {
		this.txnLimit = txnLimit;
	}
	                                                                                                                                                                                                                                                                                               
	
	
	
}
