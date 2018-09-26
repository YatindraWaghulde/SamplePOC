package com.demo.poc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.poc.model.CustomerDetails;
import com.demo.poc.model.DeviceDetails;
import com.demo.poc.repository.CustomerRepo;
import com.demo.poc.service.CustomerService;
import com.demo.poc.vo.CustomerDetailsVO;
import com.demo.poc.vo.DeviceDetailsVO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<CustomerDetails> getcustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Optional<CustomerDetailsVO> getCustomerById(Long customerId) {
		Optional<CustomerDetails> cust = customerRepo.findById(customerId);
		if(cust.isPresent()) {
			List<DeviceDetailsVO> list = new ArrayList<>();
			for (DeviceDetails deviceDetail : cust.get().getDeviceDetails()) {
				list.add(new DeviceDetailsVO(deviceDetail.getDeviceNumber(),deviceDetail.getDeviceType(),deviceDetail.getExpDate(),deviceDetail.getTxnLimit()));
			}
			
			CustomerDetailsVO vo = new CustomerDetailsVO(cust.get().getCustomerId(), cust.get().getFirstName(), cust.get().getLastName(), cust.get().getDob(), list);
			return Optional.of(vo);
		}
		
		return Optional.<CustomerDetailsVO>empty();
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails customer) {
		return customerRepo.save(customer);
	}

	@Override
	public CustomerDetails insertCustomer(CustomerDetails customer) {
		return customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		customerRepo.deleteById(customerId);
	}

}
