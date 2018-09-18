package com.demo.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.poc.model.DeviceDetails;

public interface DeviceRepository extends CrudRepository<DeviceDetails, Long>{

	
	
}
