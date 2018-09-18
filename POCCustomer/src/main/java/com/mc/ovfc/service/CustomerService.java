package com.mc.ovfc.service;

import java.util.List;
import java.util.Optional;

import com.mc.ovfc.model.CustomerDetails;

public interface CustomerService {

	List<CustomerDetails> getcustomers();

	Optional<CustomerDetails> getCustomerById(Long customerId);

	CustomerDetails updateCustomer(CustomerDetails customer);

	CustomerDetails insertCustomer(CustomerDetails customer);

	void deleteCustomer(Long customerId);

}
