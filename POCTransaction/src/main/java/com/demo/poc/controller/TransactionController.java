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

import com.demo.poc.exception.TransactionNotFoundException;
import com.demo.poc.model.ErrorMessage;
import com.demo.poc.model.TransactionDetails;
import com.demo.poc.repository.TransactionRepository;
import com.demo.poc.service.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v2/demo")
@Api(value="Employee's API",description="Sample API for 1V4C")
public class TransactionController 
{
	@Autowired
	private TransactionService service;
	
	@Autowired
	TransactionRepository custRepo;
	
	@ApiOperation(value="Returns the transaction with specified txnId")
	@RequestMapping(method=RequestMethod.GET,value="/transaction/{txn}")
	public Optional<TransactionDetails> getTransaction(@PathVariable Long txn) throws TransactionNotFoundException{
	
		if(service.getTransaction(txn)==null)
			throw new TransactionNotFoundException("Entered Transaction Number "+txn+" is not Available");
		return service.getTransaction(txn);
	}
	
	@ApiOperation(value="Returns the list of transactions")
	@RequestMapping(method=RequestMethod.GET,value="/transactions")
	public List<TransactionDetails> getAllTransaction(){
		return service.getAllTransaction();
	}
	
	@ApiOperation(value="Add the transaction")
	@RequestMapping(method=RequestMethod.POST,value="/transactions")
	public void addDevice(@RequestBody TransactionDetails txn)
	{
		service.addTransaction(txn);
	}
	
	@ApiOperation(value="Update the transaction")
	@RequestMapping(method=RequestMethod.PUT,value="/transactions/{txn}")
	public void updateTransaction(@RequestBody TransactionDetails transactions)
	{
		service.updateTransaction(transactions);
	}
	
	@ApiOperation(value="Delete the transaction")
	@RequestMapping(method=RequestMethod.DELETE,value="/transactions/{txn}")
	public void deleteTransaction(@PathVariable("txn") int txn){
		service.deleteTransaction(txn);
	}
		
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex)
	{
		ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
			errorMessage.setErrorMessage(ex.getMessage());
			return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
}
