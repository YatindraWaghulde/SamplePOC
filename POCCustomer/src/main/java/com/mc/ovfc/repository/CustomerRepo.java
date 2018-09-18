package com.mc.ovfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mc.ovfc.model.CustomerDetails;

public interface CustomerRepo extends JpaRepository<CustomerDetails, Long> {

}
