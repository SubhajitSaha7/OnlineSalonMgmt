package com.cg.salon.service;

import java.util.List;

import com.cg.salon.dto.CustomerDto;
import com.cg.salon.entity.Customer;
import com.cg.salon.exceptions.CustomerNotFoundException;

public interface ICustomerService {

	public Integer addCustomer(CustomerDto dto);

	public Customer getCustomerById(int cid) throws CustomerNotFoundException;

	public List<Customer> getCustomerByName(String name) throws CustomerNotFoundException;

	public List<Customer> getCustomerByCity(String city) throws CustomerNotFoundException;

	public List<Customer> getCustomerByContactNo(String contactNo) throws CustomerNotFoundException;

	public boolean editCustomerDetails(CustomerDto dto) throws CustomerNotFoundException;
}
