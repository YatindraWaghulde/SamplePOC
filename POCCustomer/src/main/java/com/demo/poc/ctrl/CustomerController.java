package com.demo.poc.ctrl;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.poc.config.DataNotFoundException;
import com.demo.poc.config.ErrorMessage;
import com.demo.poc.model.CustomerDetails;
import com.demo.poc.service.CustomerService;
import com.demo.poc.vo.CustomerDetailsVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="customeroperactions", description="Operations pertaining to customer in Online")
public class CustomerController {
	private final Logger LOGGER = LoggerFactory.logger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * return all customers from database
	 * @return list of customer
	 * @throws DataNotFoundException 
	 */
	@ApiOperation(value = "View a list of customers", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list of customers"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping(value="/customers")
	public List<CustomerDetails> getcustomers() throws DataNotFoundException {
		List<CustomerDetails> customerDetails = customerService.getcustomers();
		if(customerDetails == null) {
			LOGGER.error("No record found.");
			throw new DataNotFoundException("No record found.");
		}
		return customerDetails;
	}
	
	/**
	 * it will return customer object.
	 * @param customerId
	 * @return
	 * @throws DataNotFoundException 
	 */
	@ApiOperation(value = "Fetch a Customer based on cuistomerId")
	@GetMapping(value="/customers/{customerId}")
	public Optional<CustomerDetailsVO> getCustomer(@PathVariable Long customerId) throws DataNotFoundException {
		LOGGER.error("Inside getCustomer");
		Optional<CustomerDetailsVO> cust = customerService.getCustomerById(customerId);
		if (!cust.isPresent()) {
			throw new DataNotFoundException("Customer Not Found with customer id : "+customerId);
	    }
		return cust;
	}
	
	/**
	 * update the customer details in database
	 * @param customer
	 * @return
	 */
	@ApiOperation(value = "Update a Customer")
	@PutMapping(value="/customers")
	public CustomerDetails updateCustomer(@RequestBody CustomerDetails customer) {
		LOGGER.info("updating customer record.");
		return customerService.updateCustomer(customer);
	}
	
	
	/**
	 * Add new customer entry in database.
	 * @param customerDetails
	 * @return
	 */
	@ApiOperation(value = "Add a Customer")
	@PostMapping(value="/customers")
	public CustomerDetails insertCustomer(@RequestBody CustomerDetails customerDetails) {
		LOGGER.info("adding customer record.");
		return customerService.insertCustomer(customerDetails);
	}
	
	
	/**
	 * it will return Response entity with error id and error message
	 * @param ex
	 * @return ResponseEntity with errorMessage and errorCode
	 */
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex)
	{
		LOGGER.info("Exception occured."+ex);
		ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
			errorMessage.setErrorMessage(ex.getMessage());
			return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	} 

}





