package com.demo.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.poc.exception.DeviceNotFoundException;
import com.demo.poc.model.DeviceDetails;

@Service
public class ConsumerService {

	
	@Autowired
	RestTemplate template;
	
	@Value("${uriConsume}")
	private String uri;
	
	public DeviceDetails getDevice(Long deviceNumber) throws DeviceNotFoundException{
		
		DeviceDetails deviceDetails=new DeviceDetails();
		ResponseEntity<DeviceDetails> response = null;
		
		uri=uri+deviceNumber;
		try{
			 response = template.getForEntity(uri,DeviceDetails.class);
		}
		catch (Exception e) {
		}
		if(response==null)
			throw new DeviceNotFoundException("Entered Device Number "+deviceNumber+" is not Available or Device Service is Unavailable at the time");
		
				deviceDetails.setDeviceNumber(response.getBody().getDeviceNumber());
				deviceDetails.setDeviceType(response.getBody().getDeviceType());
				deviceDetails.setExpDate(response.getBody().getExpDate());
				deviceDetails.setTxnLimit(response.getBody().getTxnLimit());
		
		return deviceDetails;
		
		
	}
	
	
	
} 