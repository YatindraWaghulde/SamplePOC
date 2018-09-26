package com.demo.poc.vo;

import java.io.Serializable;
import java.util.Date;

public class DeviceDetailsVO implements Serializable{

	private static final long serialVersionUID = -8658798312716361398L;
	public DeviceDetailsVO() {
	}
	private Long deviceNumber;
	private String deviceType;
	private Date expDate;
	private Integer txnLimit;
	
	
	public DeviceDetailsVO(Long deviceNumber, String deviceType, Date expDate, Integer txnLimit) {
		super();
		this.deviceNumber = deviceNumber;
		this.deviceType = deviceType;
		this.expDate = expDate;
		this.txnLimit = txnLimit;
	}
	public void setDeviceNumber(Long deviceNumber) {
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
	
	
	public Long getDeviceNumber() {
		return deviceNumber;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public Date getExpDate() {
		return expDate;
	}
	public Integer getTxnLimit() {
		return txnLimit;
	}
	                                                                                                                                                                                                                                                                                               
	
	
	
} 
