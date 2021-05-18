package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.dto.CustomerDto;
import com.cg.salon.entity.Customer;
import com.cg.salon.exceptions.CustomerNotFoundException;

@Service("customerservice")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerdao;
	
	
	public Integer addCustomer(CustomerDto dto) {
		
		Customer customer = new Customer();
		
		customer.setName(dto.getName());
		customer.setContactNo(dto.getContactNo());
		customer.setEmail(dto.getEmail());
		customer.setDob(dto.getDob());
		customer.setArea(dto.getArea());
		customer.setCity(dto.getCity());
		customer.setDoorNo(dto.getDoorNo());
		customer.setPincode(dto.getPincode());
		customer.setState(dto.getState());
		customer.setStreet(dto.getStreet());
		
		Customer savedcustomer = customerdao.save(customer);
		return savedcustomer.getUserId();
	}
	
	@Override
	public Customer viewCustomerById(int cid)throws CustomerNotFoundException {
		Optional<Customer> optservice = customerdao.findById(cid);
		if (!optservice.isPresent())
			throw new CustomerNotFoundException("customer does not exists for "+cid);
		return optservice.get();
	}
	
	@Override
	public List<Customer> viewCustomerByName(String name) throws CustomerNotFoundException {
		List<Customer> lst = customerdao.viewCustomerByName(name);
		if (lst.isEmpty())
			throw new CustomerNotFoundException("No customer found with name " + name);
		return lst;
	}
	
	@Override
	public List<Customer> viewCustomerByCity(String city)throws CustomerNotFoundException {
		List<Customer> lst = customerdao.viewCustomerByCity(city);
		if (lst.isEmpty())
			throw new CustomerNotFoundException("No customer found with city " + city);
		return lst;
	}
	
	@Override
	public List<Customer> viewCustomerByContactNo(String contactNo)throws CustomerNotFoundException {
		List<Customer> lst = customerdao.viewCustomerByContactNo(contactNo);
		if (lst.isEmpty())
			throw new CustomerNotFoundException("No customer found" + contactNo);
		return lst;
	}
	
	@Transactional
	@Override
	public boolean editCustomerDetails(CustomerDto dto)throws CustomerNotFoundException {
		
		Optional<Customer> optservice = customerdao.findById(dto.getUserId());
		if (!optservice.isPresent())
			throw new CustomerNotFoundException("No customer found");
		Customer customer = optservice.get();
		
		customer.setName(dto.getName());
		customer.setContactNo(dto.getContactNo());
		customer.setEmail(dto.getEmail());
		customer.setDob(dto.getDob());
		customer.setArea(dto.getArea());
		customer.setCity(dto.getCity());
		customer.setDoorNo(dto.getDoorNo());
		customer.setPincode(dto.getPincode());
		customer.setState(dto.getState());
		customer.setStreet(dto.getStreet());
		
		Customer persistedCustomer = customerdao.save(customer);
		return true;
	}
}
