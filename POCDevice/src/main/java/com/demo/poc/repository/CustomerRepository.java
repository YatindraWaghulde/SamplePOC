package com.demo.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.poc.model.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails, Long>{

}
