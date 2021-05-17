package com.cg.salon.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.salon.dto.CustomerDto;
import com.cg.salon.dto.CustomerSuccessMessage;
import com.cg.salon.entity.Customer;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.ValidateCustomerException;
import com.cg.salon.service.ICustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private ICustomerService service;
	
	@PostMapping("addcustomer")
	public CustomerSuccessMessage addCustomer(@Valid @RequestBody CustomerDto custdto, BindingResult br) throws ValidateCustomerException
	{
		System.out.println("Customer added");
		
		if (br.hasErrors())
			throw new ValidateCustomerException(br.getFieldErrors());
		int cid = service.addCustomer(custdto);
		
		return new CustomerSuccessMessage("Your generated customer id is "+cid);
	}
	
	@PutMapping("editcustomer")
	public CustomerSuccessMessage editCustomerDetails(@Valid @RequestBody CustomerDto custdto, BindingResult br) 
			throws ValidateCustomerException, CustomerNotFoundException {
		
		if (br.hasErrors())
			throw new ValidateCustomerException(br.getFieldErrors());
		
		service.editCustomerDetails(custdto);
		return new CustomerSuccessMessage("Customer details edited successfully");
	}
	
	@GetMapping("viewcustomerbyid/{customerid}")
	public Customer viewCustomerById(@PathVariable("customerid") int userId)throws CustomerNotFoundException{
		return service.viewCustomerById(userId);
		
	}
	
	@GetMapping("viewcustomerbyname/{customername}")
	public List<Customer> viewCustomerByName(@PathVariable("customername") String name)throws CustomerNotFoundException
	{
		return service.viewCustomerByName(name);
	}
	
	@GetMapping("viewcustomerbycontactno/{customercontactno}")
	public List<Customer> viewCustomerByContactNo(@PathVariable("customercontactno") String contactNo)throws CustomerNotFoundException
	{
		return service.viewCustomerByContactNo(contactNo);
	}
	
	@GetMapping("viewcustomerbycity/{customercity}")
	public List<Customer> viewCustomerByCity(@PathVariable("customercity") String city)throws CustomerNotFoundException
	{
		return service.viewCustomerByCity(city);
	}
}
