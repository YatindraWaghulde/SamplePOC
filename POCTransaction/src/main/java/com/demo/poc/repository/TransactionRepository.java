package com.demo.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.poc.model.TransactionDetails;

public interface TransactionRepository extends CrudRepository<TransactionDetails, Long>{

	
	
}
