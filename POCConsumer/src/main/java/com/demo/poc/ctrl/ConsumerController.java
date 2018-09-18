package com.demo.poc.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.poc.exception.DeviceNotFoundException;
import com.demo.poc.model.DeviceDetails;
import com.demo.poc.model.ErrorMessage;
import com.demo.poc.service.ConsumerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/demo")
@Api(value="Employee's API",description="Sample API for Consumer")
public class ConsumerController 
{
	@Autowired
	private ConsumerService service;
	
	DeviceDetails detail;
	
	@ApiOperation(value="Returns the device with specified deviceId")
	@RequestMapping(method=RequestMethod.GET,value="/devices/{deviceNumber}")
	public DeviceDetails getDevice(@PathVariable("deviceNumber") long deviceNumber) throws DeviceNotFoundException{
		detail=service.getDevice(deviceNumber);
		System.out.println("DEvice++++++++> "+detail);
		if(detail==null)
			throw new DeviceNotFoundException("Entered Device Number "+deviceNumber+" is not Available or Device Service is Unavailable at the time");
		
		System.out.println(detail.getDeviceType());
		System.out.println(detail.getDeviceNumber());
		System.out.println(detail.getExpDate());
		System.out.println(detail.getTxnLimit());
		return detail;
	}
	
	@ExceptionHandler(DeviceNotFoundException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex)
	{
		ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
			errorMessage.setErrorMessage(ex.getMessage());
			return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
} 
