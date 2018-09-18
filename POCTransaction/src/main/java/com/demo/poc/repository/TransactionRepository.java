package com.transaction.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.transaction.demo.model.TransactionDetails;

public interface TransactionRepository extends CrudRepository<TransactionDetails, Long>{

	
	
}
