package com.demo.poc.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.poc.exception.DeviceNotFoundException;
import com.demo.poc.model.CustomerDetails;
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
	private RestTemplate restTemplate;
	
	@Value("${uriforcustomer}")
	private String uriForCustomer;
	@Value("${uriforadddevice}")
	private String uriForAddDevice;
	
	@Autowired
	private ConsumerService service;
		
	private DeviceDetails detail;
	
	@ApiOperation(value="Returns the device with specified deviceId")
	@RequestMapping(method=RequestMethod.GET,value="/devices/{deviceNumber}")
	public DeviceDetails getDevice(@PathVariable("deviceNumber") long deviceNumber) throws DeviceNotFoundException{
		detail=service.getDevice(deviceNumber);
		if(detail==null)
			throw new DeviceNotFoundException("Entered Device Number "+deviceNumber+" is not Available or Device Service is Unavailable at the time");

		return detail;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) throws DeviceNotFoundException {
		CustomerDetails response = null;
		try{
			Object obj[] = {}; 
			 response = restTemplate.postForObject(uriForCustomer,customer,CustomerDetails.class,obj);
		}
		catch (Exception e) {
		}
		if(response==null)
			throw new DeviceNotFoundException("Customer is unable to save.");
		
				
		
		return response;
	
	}


	@ApiOperation(value="Returns the customer with specified customerId")
	@RequestMapping(method=RequestMethod.GET,value="/customers/{customerId}")
	public ResponseEntity<CustomerDetails> getCustomer(@PathVariable("customerId") long customerId) throws DeviceNotFoundException{
		ResponseEntity<CustomerDetails> response = null;
		
		try{
			 response = restTemplate.getForEntity(uriForCustomer+"/"+customerId,CustomerDetails.class);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		if(response==null)
			throw new DeviceNotFoundException("Entered customer id "+customerId+" is not Available or Device Service is Unavailable at the time");

		return response;
	}
	
	@ApiOperation(value="Returns the customers")
	@RequestMapping(method=RequestMethod.GET,value="/customers")
	public ResponseEntity<List<CustomerDetails>> getCustomers() throws DeviceNotFoundException{
		ResponseEntity<List<CustomerDetails>> response = null;
		
		try{
			response = restTemplate.exchange(
						uriForCustomer,
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<CustomerDetails>>() {
						});
		}
		catch (Exception e) {
			System.out.println(e);
		}
		if(response==null)
			throw new DeviceNotFoundException("Customer is not available.");

		return response;
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
