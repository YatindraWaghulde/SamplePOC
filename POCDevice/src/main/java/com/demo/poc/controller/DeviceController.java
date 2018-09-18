package com.demo.poc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.poc.exception.DeviceNotFoundException;
import com.demo.poc.model.CustomerDetails;
import com.demo.poc.model.DeviceDetails;
import com.demo.poc.model.ErrorMessage;
import com.demo.poc.repository.CustomerRepository;
import com.demo.poc.repository.DeviceRepository;
import com.demo.poc.service.DeviceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/masterCard")
@Api(value="Employee's API",description="Sample API for 1V4C")
public class DeviceController 
{
	@Autowired
	private DeviceService service;
	
	@Autowired
	CustomerRepository custRepo;
	
	@ApiOperation(value="Returns the device with specified deviceId")
	@RequestMapping(method=RequestMethod.GET,value="/devices/{deviceNumber}")
	public Optional<DeviceDetails> getDevice(@PathVariable("deviceNumber") long deviceNumber) throws DeviceNotFoundException{
	
		if(service.getDevice(deviceNumber)==null)
			throw new DeviceNotFoundException("Entered Device Number "+deviceNumber+" is not Available");
		return service.getDevice(deviceNumber);
	}
	
	@ApiOperation(value="Returns the list of devices")
	@RequestMapping(method=RequestMethod.GET,value="/devices")
	public List<DeviceDetails> getAllDevices(){
		return service.getAllDevices();
	}
	
	@ApiOperation(value="Add the device")
	@RequestMapping(method=RequestMethod.POST,value="/devices")
	public void addDevice(@RequestBody DeviceDetails device)
	{
		
		if(device.getCustomerDetails() != null && device.getCustomerDetails().getCustomerId() != null  &&  device.getCustomerDetails().getCustomerId() > 0){
			Long custId = device.getCustomerDetails().getCustomerId();
			Optional<CustomerDetails> details=(Optional<CustomerDetails>) custRepo.findById(custId);
			device.setCustomerDetails(details.get());
		}
		service.addDevice(device);
	}
	
	@ApiOperation(value="Update the device")
	@RequestMapping(method=RequestMethod.PUT,value="/devices")
	public void updateDevice(@RequestBody DeviceDetails device)
	{
		if(device.getCustomerDetails().getCustomerId()!=null && device.getDeviceNumber()!=null)
			
		
		service.updateDevice(device);
	}
	
	@ApiOperation(value="Delete the Device")
	@RequestMapping(method=RequestMethod.DELETE,value="/devices/{deviceNumber}")
	public void deleteEmployee(@PathVariable("deviceId") int deviceNumber){
		service.deleteDevice(deviceNumber);
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
