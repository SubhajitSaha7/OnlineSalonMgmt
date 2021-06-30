package com.cg.salon.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.util.SalonConstants;

/*
 * @Author - Madhurima Mallick
 * Description - This rest controller class contains the service implementations regarding Customer Management.
 */

@RestController
public class CustomerRestController {

	@Autowired
	private ICustomerService service;

	Logger logger = LoggerFactory.getLogger(CustomerRestController.class);

	/*
	 * Method Name - addCustomer 
	 * Return Type - Integer 
	 * Parameter - Instance of CustomerDto 
	 * Description - Adds a new Customer
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("addcustomer")
	public CustomerSuccessMessage addCustomer(@Valid @RequestBody CustomerDto custdto, BindingResult br)
			throws ValidateCustomerException {
		logger.info("I am in add customer");

		if (br.hasErrors())
			throw new ValidateCustomerException(br.getFieldErrors());
		int cid = service.addCustomer(custdto);

		return new CustomerSuccessMessage(SalonConstants.CUSTOMER_DETAILS_ADDED + cid);
	}

	/*
	 * Method Name - editCustomerDetails 
	 * Return Type - boolean 
	 * Parameter - Instance of CustomerDto 
	 * Description - edits the required fields of an existing Customer
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("editcustomer")
	public CustomerSuccessMessage editCustomerDetails(@Valid @RequestBody CustomerDto custdto, BindingResult br)
			throws ValidateCustomerException, CustomerNotFoundException {

		if (br.hasErrors())
			throw new ValidateCustomerException(br.getFieldErrors());

		service.editCustomerDetails(custdto);
		return new CustomerSuccessMessage(SalonConstants.CUSTOMER_DETAILS_EDITED);
	}

	/*
	 * Method Name - viewCustomerById 
	 * Return Type - Customer 
	 * Parameter - customerId
	 * Description - returns the instance for the Customer corresponding to the given customer id 
	 * Throws - CustomerNotFoundException, if the Customer id does not exist.
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewcustomerbyid/{customerid}")
	public Customer getCustomerById(@PathVariable("customerid") int userId) throws CustomerNotFoundException {
		return service.getCustomerById(userId);

	}

	/*
	 * Method Name - viewCustomerByName 
	 * Return Type - List 
	 * Parameter - Customer Name
	 * Description - returns the list of Customer corresponding to the given Customer name 
	 * Throws - CustomerNotFoundException, if the Customer does not exist for given name.
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewcustomerbyname/{customername}")
	public List<Customer> getCustomerByName(@PathVariable("customername") String name)
			throws CustomerNotFoundException {
		return service.getCustomerByName(name);
	}

	/*
	 * Method Name - viewCustomerByContactNo 
	 * Return Type - List 
	 * Parameter - Customer Contact No. 
	 * Description - returns the list of Customer corresponding to the given Customer Contact no. 
	 * Throws - CustomerNotFoundException, if the Customer does not exists for given contact no.
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewcustomerbycontactno/{customercontactno}")
	public List<Customer> getCustomerByContactNo(@PathVariable("customercontactno") String contactNo)
			throws CustomerNotFoundException {
		return service.getCustomerByContactNo(contactNo);
	}

	/*
	 * Method Name - viewCustomerByCity 
	 * Return Type - List 
	 * Parameter - Customer City 
	 * Description - returns the list of Customer corresponding to the given Customer city 
	 * Throws - CustomerNotFoundException, if the Customer does not exists for given city.
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewcustomerbycity/{customercity}")
	public List<Customer> getCustomerByCity(@PathVariable("customercity") String city)
			throws CustomerNotFoundException {
		return service.getCustomerByCity(city);
	}
}
