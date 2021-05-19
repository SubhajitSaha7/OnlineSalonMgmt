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
import com.cg.util.SalonConstraints;

@Service("customerservice")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerdao;
	
	@Transactional
	@Override
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
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_EXIST + cid);
		return optservice.get();
	}
	
	@Override
	public List<Customer> viewCustomerByName(String name) throws CustomerNotFoundException {
		List<Customer> lst = customerdao.findByName(name);
		if (lst.isEmpty())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_EXIST);
		return lst;
	}
	
	@Override
	public List<Customer> viewCustomerByCity(String city)throws CustomerNotFoundException {
		List<Customer> lst = customerdao.findByCity(city);
		if (lst.isEmpty())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_EXIST);
		return lst;
	}
	
	@Override
	public List<Customer> viewCustomerByContactNo(String contactNo)throws CustomerNotFoundException {
		List<Customer> lst = customerdao.findByContactNo(contactNo);
		if (lst.isEmpty())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_EXIST);
		return lst;
	}
	
	@Transactional
	@Override
	public boolean editCustomerDetails(CustomerDto dto)throws CustomerNotFoundException {
		
		Optional<Customer> optservice = customerdao.findById(dto.getUserId());
		if (!optservice.isPresent())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_EXIST);
		
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
