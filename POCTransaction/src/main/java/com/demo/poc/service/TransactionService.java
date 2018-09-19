package com.demo.poc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.poc.model.TransactionDetails;
import com.demo.poc.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
	
	public Optional<TransactionDetails> getTransaction(Long txn){
		if(repository.existsById(txn))
			return repository.findById(txn);
		else
			return null;
	}
	
	public List<TransactionDetails> getAllTransaction()
	{
		List<TransactionDetails> txn=new ArrayList<TransactionDetails>();
		repository.findAll().forEach(txn::add);
		return txn;
	}
	
	public TransactionDetails addTransaction(TransactionDetails txn)
	{		
		return repository.save(txn);
	}
	
	public void updateTransaction(TransactionDetails txn)
	{ 		
		repository.save(txn);
	} 
	
	public void deleteTransaction(long txn)
	{
		repository.deleteById(txn);
	}
		
} 