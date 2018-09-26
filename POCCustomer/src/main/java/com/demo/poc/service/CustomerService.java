package com.demo.poc.service;

import java.util.List;
import java.util.Optional;

import com.demo.poc.model.CustomerDetails;
import com.demo.poc.vo.CustomerDetailsVO;

public interface CustomerService {

	List<CustomerDetails> getcustomers();

	Optional<CustomerDetailsVO> getCustomerById(Long customerId);

	CustomerDetails updateCustomer(CustomerDetails customer);

	CustomerDetails insertCustomer(CustomerDetails customer);

	void deleteCustomer(Long customerId);

}
