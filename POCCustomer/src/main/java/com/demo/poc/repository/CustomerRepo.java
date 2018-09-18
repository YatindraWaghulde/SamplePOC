package com.demo.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.poc.model.CustomerDetails;

public interface CustomerRepo extends JpaRepository<CustomerDetails, Long> {

}
