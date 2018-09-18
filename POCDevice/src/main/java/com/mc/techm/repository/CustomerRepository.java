package com.mc.techm.repository;

import org.springframework.data.repository.CrudRepository;

import com.mc.techm.model.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails, Long>{

}
