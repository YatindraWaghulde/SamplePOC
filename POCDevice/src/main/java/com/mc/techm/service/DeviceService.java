package com.mc.techm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.techm.model.CustomerDetails;
import com.mc.techm.model.DeviceDetails;
import com.mc.techm.repository.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	DeviceRepository repository;
	
	
	public Optional<DeviceDetails> getDevice(Long deviceNumber){
		if(repository.existsById(deviceNumber))
			return repository.findById(deviceNumber);
		else
			return null;
	}
	
	public List<DeviceDetails> getAllDevices()
	{
		List<DeviceDetails> employ=new ArrayList<DeviceDetails>();
		repository.findAll().forEach(employ::add);
		return employ;
	}
	
	public void addDevice(DeviceDetails device)
	{
		System.out.println("Limit "+device.getTxnLimit());
		repository.save(device);
	}
	
	public void updateDevice(DeviceDetails device)
	{ 
		
		repository.save(device);
	} 
	
	public void deleteDevice(long deviceId)
	{
		repository.deleteById(deviceId);
	}
	
	
	
	
	
}
