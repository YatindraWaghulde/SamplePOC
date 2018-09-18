package com.transaction.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.demo.model.TransactionDetails;
import com.transaction.demo.repository.TransactionRepository;

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
	
	public void addTransaction(TransactionDetails txn)
	{		
		repository.save(txn);
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
